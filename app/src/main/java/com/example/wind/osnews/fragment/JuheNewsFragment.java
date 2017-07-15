package com.example.wind.osnews.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wind.osnews.Bean.JuheBean;
import com.example.wind.osnews.R;
import com.example.wind.osnews.adapter.JuhenewsAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wind on 17-7-15.
 */

public class JuheNewsFragment extends Fragment {

    private List<JuheBean.ResultBean.DataBean> jBeanList=new ArrayList<>();
    private JuhenewsAdapter mAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_juhenews, container, false);

        RecyclerView recyclerView= (RecyclerView) view.findViewById(R.id.jrecycler_view);
        initData();

        mAdapter=new JuhenewsAdapter(getContext(),jBeanList);
        recyclerView.setAdapter(mAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

    //其他的都与普通的recyclerview写法一样,只有数据Bean不一样,现在已经可以自己造数据Bean了,最后只需要联网获取json
    // 数据添加到数组中就可以了
    private void initData() {
        JuheBean.ResultBean.DataBean bean=new JuheBean.ResultBean.DataBean();
        bean.setTitle("我要睡觉了");
        bean.setAuthor_name("十二月魔");
        bean.setCategory("1");
        bean.setDate("2017-7-14");
        bean.setThumbnail_pic_s("333");
        bean.setThumbnail_pic_s02("333");
        bean.setThumbnail_pic_s03("333");
        bean.setUniquekey("1");
        bean.setUrl("333");

        for (int i = 0; i < 10; i++) {
            jBeanList.add(bean);
        }

    }



}
