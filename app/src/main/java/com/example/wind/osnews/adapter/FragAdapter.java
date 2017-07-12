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

    public FragAdapter(FragmentManager fm,List<Fragment> fragments){
        super(fm);
        mFragments=fragments;

        titleList.add("资讯");
        titleList.add("博客");
        titleList.add("问答");
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
