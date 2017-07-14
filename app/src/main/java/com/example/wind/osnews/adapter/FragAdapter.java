package com.example.wind.osnews.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wind on 17-7-12.
 */

public class FragAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragments;
    private List<String> titleList=new ArrayList<>();

    public FragAdapter(FragmentManager fm,List<Fragment> fragments,List<String> titlelist){
        super(fm);
        mFragments=fragments;
        titleList=titlelist;

    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    //重写标题


    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }
}
