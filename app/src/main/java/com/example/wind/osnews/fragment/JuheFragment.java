package com.example.wind.osnews.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wind.osnews.R;
import com.example.wind.osnews.adapter.FragAdapter;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by wind on 17-7-12.
 */

public class JuheFragment extends Fragment {

    List<Fragment> mFragmentList;
    List<String> titleList=new ArrayList<>();
    private FragAdapter mAdapter;

    //    String url = "toutiao/index?type=top&key=3771c3180f6dd01a974767a2ebc763f1";
    String url = "toutiao/index?type=guonei&key=3771c3180f6dd01a974767a2ebc763f1";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        ItheimaHttp.init(getContext(),"http://v.juhe.cn/");
        View view = inflater.inflate(R.layout.fragment_juhe, container, false);

        TabLayout tabs= (TabLayout) view.findViewById(R.id.juhe_tabs);
        ViewPager vp= (ViewPager) view.findViewById(R.id.jviewPager);

        initFragment();

        mAdapter=new FragAdapter(getFragmentManager(),mFragmentList,titleList);

        vp.setAdapter(mAdapter);
        tabs.setupWithViewPager(vp);

        return view;
    }

    private void initFragment() {
        mFragmentList=new ArrayList<>();
        mFragmentList.add(new JuheNewsFragment());
        mFragmentList.add(new JuheNewsFragment());
        mFragmentList.add(new JuheNewsFragment());
        titleList.add("头条");
        titleList.add("笑话");
        titleList.add("图片");

    }

}










