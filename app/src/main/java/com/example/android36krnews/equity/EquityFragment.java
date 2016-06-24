package com.example.android36krnews.equity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.android36krnews.R;
import com.example.android36krnews.equity.adapter.EquityPagetAdapter;
import com.example.android36krnews.utils.Contants;
import com.example.android36krnews.utils.ui.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/15 0015.
 */
public class EquityFragment extends BaseFragment{

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<String> mTitle;

    private EquityPagetAdapter adapter;
    @Override
    protected int getLayout() {
        return R.layout.fragment_equity_layout;
    }

    @Override
    protected void initView() {
        mTabLayout = (TabLayout) mView.findViewById(R.id.entity_tablayout);
        mViewPager = (ViewPager) mView.findViewById(R.id.entity_viewpaper);
    }

    @Override
    protected void initVarible() {
        mTitle = new ArrayList<>();
        mTitle.add(Contants.EQUITY_TITLE_ALL);
        mTitle.add(Contants.EQUITY_TITLE_CENTRE);
        mTitle.add(Contants.EQUITY_TITLE_FINISH);
        mTitle.add(Contants.EQUITY_TITLE_SUCCEED);
        adapter = new EquityPagetAdapter(getFragmentManager());
        adapter.setmTitle(mTitle);
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void bindData() {

    }

    @Override
    protected void lazyLoad() {

    }
}
