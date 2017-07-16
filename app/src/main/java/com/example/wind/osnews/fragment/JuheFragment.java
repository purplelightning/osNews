package com.example.wind.osnews.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wind.osnews.Bean.JuheNewsType;
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

    private List<JuheNewsType> nt_list;

    //    String url = "toutiao/index?type=top&key=3771c3180f6dd01a974767a2ebc763f1";
//    String url = "toutiao/index?type=guonei&key=3771c3180f6dd01a974767a2ebc763f1";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        ItheimaHttp.init(getContext(),"http://v.juhe.cn/");
        View view = inflater.inflate(R.layout.fragment_juhe, container, false);

        TabLayout tabs= (TabLayout) view.findViewById(R.id.juhe_tabs);
        ViewPager vp= (ViewPager) view.findViewById(R.id.jviewPager);

        initNewsType();
        initFragment();

        mAdapter=new FragAdapter(getFragmentManager(),mFragmentList,titleList);

        vp.setAdapter(mAdapter);
        tabs.setupWithViewPager(vp);

        return view;
    }

    private void initNewsType() {
        nt_list=new ArrayList<>();
        String APPKEY = "3771c3180f6dd01a974767a2ebc763f1";

        JuheNewsType nt=new JuheNewsType(1,"头条","http://v.juhe.cn/toutiao/index?type=top&key="+ APPKEY);
        nt_list.add(nt);

        nt=new JuheNewsType(2,"国际","http://v.juhe.cn/toutiao/index?type=guoji&key="+ APPKEY);
        nt_list.add(nt);

        nt=new JuheNewsType(3,"体育","http://v.juhe.cn/toutiao/index?type=tiyu&key="+ APPKEY);
        nt_list.add(nt);

        nt=new JuheNewsType(4,"科技","http://v.juhe.cn/toutiao/index?type=keji&key="+ APPKEY);
        nt_list.add(nt);

        nt=new JuheNewsType(5,"来福笑话","http://api.laifudao.com/open/xiaohua.json");
        nt_list.add(nt);
    }

    private void initFragment() {
        mFragmentList=new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Fragment f=new JuheNewsFragment();
            Bundle b=new Bundle();//用Bundle传递新闻类型
            b.putSerializable("type",nt_list.get(i));
            f.setArguments(b);
            mFragmentList.add(f);
        }
        //不同的数据来源,数据Bean不一样,重新写一个fragment来呈现数据
        Fragment f=new JokeFragment();
        Bundle b=new Bundle();
        b.putSerializable("type",nt_list.get(4));
        f.setArguments(b);
        mFragmentList.add(f);

        titleList.add("头条");
        titleList.add("国际");
        titleList.add("体育");
        titleList.add("科技");
        titleList.add("来福笑话");
    }

}










