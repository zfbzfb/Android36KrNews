package com.example.android36krnews.equity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.android36krnews.R;
import com.example.android36krnews.equity.adapter.MyEquityAdapter;
import com.example.android36krnews.equity.entity.EquityBean;
import com.example.android36krnews.equity.entity.SyndicatesBean;
import com.example.android36krnews.utils.Contants;
import com.example.android36krnews.utils.OkHttpUtils;
import com.example.android36krnews.utils.WebViewActivity;
import com.example.android36krnews.utils.ui.BaseFragment;
import com.squareup.okhttp.Request;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/18.
 */
public class FragmentItem extends BaseFragment {

    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private MyEquityAdapter madapter;
    private LinearLayoutManager manager;

    private List<EquityBean.DataBean.Data2Bean> mlist;
    private List<EquityBean.DataBean.Data2Bean> listData2Bean;
    private EquityBean mEquityBean;
    private int type;

    private int lastItem;
    private boolean isMore = true;//解决上拉重复加载的bug

    private boolean isPrepared;
    @Override
    protected int getLayout() {
        return R.layout.fragment_equity_item_layout;
    }

    @Override
    protected void initView() {
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.equity_recyclerview);
        mSwipeRefreshLayout = (SwipeRefreshLayout) mView.findViewById(R.id.equity_swipeRefreshLayout);
        isPrepared = true;
        lazyLoad();
    }

    @Override
    protected void initVarible() {
        mlist = new ArrayList<>();
        mSwipeRefreshLayout.setColorSchemeResources(R.color.red,R.color.blue);
        manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setHasFixedSize(true);
        madapter = new MyEquityAdapter(getActivity(), 0);
        Bundle bundle = getArguments();
        if (bundle != null && bundle.containsKey("data")) {
            type = bundle.getInt("data");
        }
        getFirstData(Contants.EQUITY_URL);
    }

    @Override
    protected void initListener() {
        madapter.setmOnRecyclerViewClickListener(new MyEquityAdapter.OnRecyclerViewClickListener() {
            @Override
            public void onItemClick(View view, EquityBean.DataBean.Data2Bean db,int position) {
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("url",Contants.EQUITY_URL_ITEM+db.getId());
                startActivity(intent);
            }
        });
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (isMore) {
                    isMore = false;
                    if(mEquityBean != null){
                        String url = mEquityBean.getData().getNext_page_url();
                        getRefreshData(url);
                    }
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(mSwipeRefreshLayout.isRefreshing()){
                            mSwipeRefreshLayout.setRefreshing(false);//关闭
                        }
                    }
                }, 5000);
            }
        });
        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastItem+1 == manager.getItemCount()) {
                    if (isMore) {
                        isMore = false;
                        if(mEquityBean != null){
                            String url = mEquityBean.getData().getNext_page_url();
                            getRefreshData(url);
                        }
                    }
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastItem = manager.findLastCompletelyVisibleItemPosition();
            }
        });
    }

    @Override
    protected void bindData() {

    }

    @Override
    protected void lazyLoad() {
        if(!isPrepared || !isVisible) {
            return;
        }
    }

    public void getFirstData(String url) {

        OkHttpUtils.getAsync(url, new OkHttpUtils.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {

            }

            @Override
            public void requestSuccess(String result) {
                mEquityBean = EquityBean.getObjectFromData(result);
                List<EquityBean.DataBean.Data2Bean> list = mEquityBean.getData().getData();
                listData2Bean = new ArrayList<>();
                if(type == 0){
                    listData2Bean= list;
                }else{
                    for (int i=0;i<list.size();i++){
                        if (type==list.get(i).getStatus()){
                            Log.i("+++++",""+list.get(i).getStatus());
                            listData2Bean.add(list.get(i));
                            Log.i("+++++",""+listData2Bean.get(0));
                        }
                    }
                }
                mlist.addAll(listData2Bean);
                madapter.setMlist(mlist);
                mRecyclerView.setAdapter(madapter);
                madapter.notifyDataSetChanged();
            }
        });
    }
    public void getRefreshData(String url){
        OkHttpUtils.getAsync(url, new OkHttpUtils.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {

            }

            @Override
            public void requestSuccess(String result) {
                mEquityBean = EquityBean.getObjectFromData(result);
                List<EquityBean.DataBean.Data2Bean> list = mEquityBean.getData().getData();
                listData2Bean = new ArrayList<>();
                for (int i=0;i<list.size();i++){
                    if(type == 0){
                        listData2Bean.add(list.get(i));
                    }else {
                        if (type == list.get(i).getStatus()){
                            Log.i("+++++",""+list.get(i).getStatus());
                            listData2Bean.add(list.get(i));
                        }
                    }
                }
                mlist.addAll(listData2Bean);
                madapter.notifyDataSetChanged();
                isMore = true;
            }
        });
    }
}
