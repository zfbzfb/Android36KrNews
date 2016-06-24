package com.example.android36krnews.utils.ui;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android36krnews.R;

public class WelcomeActivity extends BaseAcitivity {

    @Override
    protected int getLayout() {
        return R.layout.activity_welcome;
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case  0 :
                    startActivity(new Intent(WelcomeActivity.this,HomeActivity.class));
                    break;
            }
        }
    };
    @Override
    protected void initView() {

        handler.sendEmptyMessageDelayed(0,3000);
    }

    @Override
    protected void initVarible() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void bindData() {

    }
}
