package com.example.android36krnews.utils.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android36krnews.R;

/**
 * 基类Acitivity
 */
public abstract class BaseAcitivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initView();
        initVarible();
        initListener();
    }

    /**
     * 获取子类布局文件
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
}
