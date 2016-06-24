package com.example.android36krnews.news;


import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android36krnews.R;
import com.example.android36krnews.news.entity.ArticleBean;
import com.example.android36krnews.utils.Contants;
import com.example.android36krnews.news.adapter.MyNewsAdapter;
import com.example.android36krnews.utils.MessageEvent;
import com.example.android36krnews.utils.OkHttpUtils;
import com.example.android36krnews.utils.RecyclerViewDivider;
import com.example.android36krnews.utils.WebViewActivity;
import com.example.android36krnews.utils.entity.Category;
import com.example.android36krnews.utils.ui.BaseFragment;
import com.example.android36krnews.utils.ui.HomeActivity;
import com.squareup.okhttp.Request;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/15 0015.
 */
public class NewsFragment extends BaseFragment {

    private ImageView mTopBarMenu;
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private TextView textTitle;

    private MyNewsAdapter adapter;
    private LinearLayoutManager manager;
    private List<ArticleBean> mlist;
    private Category mCategory;

    private int lastItem;
    private boolean isMore = true;//解决上拉重复加载的bug
    @Override
    protected int getLayout() {
        return R.layout.fragment_news_layout;
    }

    @Override
    protected void initView() {
        EventBus.getDefault().register(this);
        mTopBarMenu = (ImageView) mView.findViewById(R.id.news_top_bar_menu);
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.news_recylerview);
        textTitle = (TextView) mView.findViewById(R.id.news_top_bar_title);
        mSwipeRefreshLayout = (SwipeRefreshLayout) mView.findViewById(R.id.news_swipeRefreshLayout);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void MainThread(MessageEvent event){
        mCategory = event.getCategory();
        textTitle.setText(mCategory.getmTitle());
        if(mCategory.getmType().equals("all")){
            requestData(Contants.URL);
        }else{
            requestData(mCategory.getmHref());
        }

    }

    @Override
    protected void initVarible() {
        mRecyclerView.setHasFixedSize(true);
        manager = new LinearLayoutManager(getActivity(), OrientationHelper.VERTICAL,false);
        mRecyclerView.setLayoutManager(manager);
        adapter = new MyNewsAdapter(getActivity(),0);
        if(mCategory != null){
            requestData(mCategory.getmHref());
        }else{
            requestData(Contants.URL);
        }

//      设置下拉
//      设置进度条背景颜色
        mSwipeRefreshLayout.setProgressBackgroundColorSchemeResource(R.color.white);
//      设置进度条颜色
        mSwipeRefreshLayout.setColorSchemeResources(R.color.red,R.color.blue);
//      设置进度条的偏移量
        mSwipeRefreshLayout.setProgressViewOffset(false,0,50);
        //设置分割线
        mRecyclerView.addItemDecoration(new RecyclerViewDivider(getActivity(),LinearLayoutManager.HORIZONTAL));
        //设置动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

    }

    @Override
    protected void initListener() {
        mTopBarMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((HomeActivity)getActivity()).openDrawerLayout();
            }
        });
        adapter.setmOnRecyclerViewClickListener(new MyNewsAdapter.OnRecyclerViewClickListener() {
            @Override
            public void onItemClick(View view, ArticleBean article, int position) {
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("url",article.getmHref());
                startActivity(intent);
            }
        });

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if(mCategory == null){
                    requestData(Contants.URL);
                }else {
                    requestData(mCategory.getmHref());
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
                if(newState == RecyclerView.SCROLL_STATE_IDLE && lastItem + 1 == manager.getItemCount()){
                    if(isMore){
                        isMore = false;
                        String url;
                        if(mCategory != null){
                            url = mCategory.getmHref() + "?b_url_code=" + mlist.get(mlist.size()-1).getmId() + "&d=next";
                        }else {
                            url = Contants.URL + "?b_url_code=" + mlist.get(mlist.size()-1).getmId() + "&d=next";
                        }
                        OkHttpUtils.getAsync(url, new OkHttpUtils.DataCallBack() {
                            @Override
                            public void requestFailure(Request request, IOException e) {

                            }

                            @Override
                            public void requestSuccess(String result) {
                                Document document = Jsoup.parse(result, Contants.URL);
                                List<ArticleBean> list = ArticleBean.getArticleBeans(document);
                                mlist.addAll(list);
                                adapter.notifyDataSetChanged();
                                isMore = true;
                            }
                        });
                    }
                }
            }
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //找到最后一个选项的position
                lastItem = manager.findLastCompletelyVisibleItemPosition();
            }
        });
    }

    @Override
    protected void bindData() {

    }

    @Override
    protected void lazyLoad() {

    }

    private void requestData(String url){
        OkHttpUtils.getAsync(url, new OkHttpUtils.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {

            }
            @Override
            public void requestSuccess(String result) {
                Document document = Jsoup.parse(result,Contants.URL);
                mlist = ArticleBean.getArticleBeans(document);
                adapter.setMlist(mlist);
                mRecyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
