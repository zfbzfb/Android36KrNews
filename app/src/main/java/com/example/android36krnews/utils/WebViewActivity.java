package com.example.android36krnews.utils;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.android36krnews.R;
import com.example.android36krnews.utils.ui.BaseAcitivity;

public class WebViewActivity extends BaseAcitivity {

    private WebView mWebView;
    @Override
    protected int getLayout() {
        return R.layout.activity_webview;
    }

    @Override
    protected void initView() {
        mWebView = (WebView) this.findViewById(R.id.webview);
    }

    @Override
    protected void initVarible() {
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        Intent intent = getIntent();
        mWebView.loadUrl(intent.getStringExtra("url"));
    }

    @Override
    protected void initListener() {
        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
    }

    @Override
    protected void bindData() {

    }
}
