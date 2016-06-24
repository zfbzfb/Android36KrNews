package com.example.android36krnews.utils.ui;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.android36krnews.R;
import com.example.android36krnews.utils.Contants;
import com.example.android36krnews.utils.MessageEvent;
import com.example.android36krnews.utils.OkHttpUtils;
import com.example.android36krnews.utils.adapter.FixePagerAdapter;
import com.example.android36krnews.utils.entity.Category;
import com.squareup.okhttp.Request;

import org.greenrobot.eventbus.EventBus;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/14 0014.
 */
public class CategoryFragment extends BaseFragment {

    private ImageView mBack;
    private RecyclerView mrecyclerView;

    private LinearLayoutManager mLayoutManager;
    private FixePagerAdapter mAdapter;

    private List<Category> mlist;

    @Override
    protected int getLayout() {
        return R.layout.fragment_category_tab;
    }

    @Override
    protected void initView() {
        mBack = (ImageView) mView.findViewById(R.id.category_back);
        mrecyclerView = (RecyclerView) mView.findViewById(R.id.recyclerview);
    }

    @Override
    protected void initVarible() {

        mLayoutManager = new LinearLayoutManager(getActivity(), OrientationHelper.VERTICAL, false);
        mrecyclerView.setLayoutManager(mLayoutManager);
        mrecyclerView.setHasFixedSize(true);
        mAdapter = new FixePagerAdapter(getActivity(), 0);
        OkHttpUtils.getAsync(Contants.URL, new OkHttpUtils.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {

            }
            @Override
            public void requestSuccess(String result) {
                Log.i("+++++++++", "" + result);
                Document document = Jsoup.parse(result, Contants.URL);
                mlist = Category.getCategoryData(document);
                mrecyclerView.setAdapter(mAdapter);
                mAdapter.setList(mlist);
                mAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void initListener() {
        mAdapter.setMonRecyclerViewClickListener(new FixePagerAdapter.OnRecyclerViewClickListener() {
            @Override
            public void onItemClick(View view, Category category) {
                EventBus.getDefault().post(new MessageEvent(category));
                ((HomeActivity) getActivity()).closeDrawerLayout();
            }
        });
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((HomeActivity) getActivity()).closeDrawerLayout();
            }
        });
    }

    @Override
    protected void bindData() {

    }

    @Override
    protected void lazyLoad() {

    }
}
