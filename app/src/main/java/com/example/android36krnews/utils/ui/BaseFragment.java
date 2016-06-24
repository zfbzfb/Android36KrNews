package com.example.android36krnews.utils.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/6/14 0014.
 * 基类Fragment
 */
public abstract class BaseFragment extends Fragment {

    protected View mView;
    protected boolean isVisible;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(mView == null) {
            mView = inflater.inflate(getLayout(), container, false);
        }
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initVarible();
        initListener();
        //bindData();
    }

    /**
     * 获取子类的布局文件
     * @return
     */
    protected abstract int getLayout();

    /**
     * 初始化控件
     */
    protected abstract void initView();

    /**
     * 初始化变量
     */
    protected abstract void initVarible();

    /**
     * 初始化时间处理
     */
    protected abstract void initListener();

    /**
     * 绑定数据
     */
    protected abstract  void bindData();

    /**
     * 在这里实现Fragment数据的缓加载.
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInVisible();
        }
    }

    /**
     * 界面显示的时候，加载数据
     */
    protected void onVisible(){
        lazyLoad();
    }

    /**
     * 界面不显示的时候，执行
     */
    protected void onInVisible(){

    }

    /**
     * 加载数据
     */
    protected abstract void lazyLoad();
}
