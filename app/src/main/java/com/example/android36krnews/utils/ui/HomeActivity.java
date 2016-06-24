package com.example.android36krnews.utils.ui;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.RadioGroup;

import com.example.android36krnews.R;
import com.example.android36krnews.equity.EquityFragment;
import com.example.android36krnews.find.FindFragment;
import com.example.android36krnews.me.LoginActivity;
import com.example.android36krnews.me.MeFragment;
import com.example.android36krnews.news.NewsFragment;
import com.example.android36krnews.utils.adapter.MyViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseAcitivity implements RadioGroup.OnCheckedChangeListener,ViewPager.OnPageChangeListener{

    private RadioGroup mradioGroup;
    private ViewPager mViewPager;
    private DrawerLayout mDrawerLayout;

    private MyViewPagerAdapter mMyViewPagerAdapter;
    private List<Fragment> mlist;


    @Override
    protected int getLayout() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView() {
        mDrawerLayout = (DrawerLayout) this.findViewById(R.id.drawerlayout);
        mradioGroup = (RadioGroup) this.findViewById(R.id.radiogroup);
        mViewPager = (ViewPager) this.findViewById(R.id.viewpager);
        mViewPager.setOffscreenPageLimit(3);
        mlist = new ArrayList<>();
        mlist.add(new NewsFragment());
        mlist.add(new EquityFragment());
        mlist.add(new FindFragment());
        mlist.add(new MeFragment());
        mMyViewPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager(),mlist);
        mViewPager.setAdapter(mMyViewPagerAdapter);
    }

    @Override
    protected void initVarible() {
        mradioGroup.check(R.id.home_tab_news);
    }

    @Override
    protected void initListener() {
        mradioGroup.setOnCheckedChangeListener(this);
        mViewPager.setOnPageChangeListener(this);
    }

    @Override
    protected void bindData() {

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i){
            case R.id.home_tab_news:
                mViewPager.setCurrentItem(0,true);
                break;
            case R.id.home_tab_equity:
                mViewPager.setCurrentItem(1,true);
                break;
            case R.id.home_tab_find:
                mViewPager.setCurrentItem(2,true);
                break;
            case R.id.home_tab_me:
                mViewPager.setCurrentItem(3,true);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position){
            case 0:
                mradioGroup.check(R.id.home_tab_news);
                break;
            case 1:
                mradioGroup.check(R.id.home_tab_equity);
                break;
            case 2:
                mradioGroup.check(R.id.home_tab_find);
                break;
            case 3:
                mradioGroup.check(R.id.home_tab_me);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public void closeDrawerLayout(){
        mDrawerLayout.closeDrawer(Gravity.LEFT);
    }
    public void openDrawerLayout(){
        mDrawerLayout.openDrawer(Gravity.LEFT);

    }
    public void login(View view){
        switch (view.getId()){
            case R.id.fragment_me_login_image :
            case R.id.fragment_me_image :
            case R.id.fragment_me_login_text :
            case R.id.linearlayout_wdxx :
            case R.id.linearlayout_wddd :
            case R.id.linearlayout_zhxx :
            case R.id.linearlayout_gtrrz :
            case R.id.linearlayout_wscdwz :
            case R.id.linearlayout_wtzdgs :
            case R.id.linearlayout_wdtzj :
                startActivity(new Intent(this,LoginActivity.class));
                break;
            case R.id.fragment_me_set_image :
                break;
            case R.id.linearlayout_ljgqtz :
                break;
            case R.id.linearlayout_kfrx :
                break;
            case R.id.linearlayout_gtj :
                break;
        }
    }
}
