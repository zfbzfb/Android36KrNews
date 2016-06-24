package com.example.android36krnews.equity.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.example.android36krnews.equity.FragmentItem;
import com.example.android36krnews.utils.Contants;

import java.util.List;

/**
 * Created by Administrator on 2016/6/18.
 */
public class EquityPagetAdapter extends FragmentStatePagerAdapter {

    private List<String> mTitle;
    public EquityPagetAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setmTitle(List<String> mTitle) {
        this.mTitle = mTitle;
    }

    @Override
    public Fragment getItem(int position) {
        FragmentItem fragment = new FragmentItem();
        Bundle bundle = new Bundle();
        if(position == 0){
            bundle.putInt("data",0);
            fragment.setArguments(bundle);
        }else if(position == 1){
            bundle.putInt("data",30);
            fragment.setArguments(bundle);
        }else if(position == 2){
            bundle.putInt("data",35);
            fragment.setArguments(bundle);
        }else if(position == 3){
            bundle.putInt("data",50);
            fragment.setArguments(bundle);
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return mTitle.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle.get(position);
    }
}
