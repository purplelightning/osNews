package com.example.wind.osnews.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wind.osnews.R;
import com.example.wind.osnews.adapter.FragAdapter;
import com.itheima.retrofitutils.ItheimaHttp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wind on 17-7-12.
 */
//资讯列表http://www.oschina.net/action/apiv2/news?pageToken=
//博客列表www.oschina.net/action/apiv2/banner?catalog=1
//详情页面http://www.oschina.net/action/apiv2/news?id=77953
//问答:http://www.oschina.net/action/apiv2/question
//评论http://www.oschina.net/action/apiv2/comment?parts=refer,reply&sourceId=77964&type=6
//活动http://www.oschina.net/action/apiv2/event
//登录http://www.oschina.net/action/api/login_validate

public class HomeFragment extends Fragment{

    private List<Fragment> mFragmentList;
    private FragAdapter mAdapter;
    private List<String> titleListnews=new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home,container,false);

        TabLayout tabs= (TabLayout) view.findViewById(R.id.tabs);
        ViewPager vp= (ViewPager) view.findViewById(R.id.viewPager);

        initData();

        mAdapter=new FragAdapter(getFragmentManager(),mFragmentList,titleListnews);
        vp.setAdapter(mAdapter);
        //将tab与viewpager绑定起来
        tabs.setupWithViewPager(vp);

        return view;
    }

    private void initData() {
        mFragmentList=new ArrayList<>();
        mFragmentList.add(new NewsFragment());
        mFragmentList.add(new BlogFragment());
        mFragmentList.add(new QuestionFragment());


        titleListnews.add("资讯");
        titleListnews.add("博客");
        titleListnews.add("问答");
    }

}









