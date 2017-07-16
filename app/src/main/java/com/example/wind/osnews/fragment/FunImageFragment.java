package com.example.wind.osnews.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.wind.osnews.Bean.FunimageBean;
import com.example.wind.osnews.Bean.JokeBean;
import com.example.wind.osnews.Bean.JuheNewsType;
import com.example.wind.osnews.R;
import com.example.wind.osnews.Utils.MyStringRequest;
import com.example.wind.osnews.adapter.FunImageAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wind on 17-7-16.
 */

public class FunImageFragment extends Fragment {

    RecyclerView mRecyclerView;
    FunImageAdapter mAdapter;
    List<FunimageBean> funimgList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragmment_funimage,container,false);

        mRecyclerView= (RecyclerView) view.findViewById(R.id.funimage_recyclerview);

        funimgList=new ArrayList<>();
        initData();

        mAdapter=new FunImageAdapter(getContext(),funimgList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }

    private void initData() {
        JuheNewsType nt = (JuheNewsType) getArguments().getSerializable("type");
        //创建请求队列
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        MyStringRequest request = new MyStringRequest(
                Request.Method.GET,
                nt.getUrl(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        System.out.println(s);
                        try {
                            //这里的stringrequest解析json数据时会出现乱码,不能返回,要自定义MyStringReqeust
                            //http://blog.csdn.net/aengui/article/details/49804599

                            /*JSONObject job = new JSONObject(s);
                            JSONObject result = job.getJSONObject("result");
                            JSONArray ja = result.getJSONArray("data");*/
                            List<FunimageBean> news = new ArrayList<>();
                            JSONArray ja = new JSONArray(s);
                            for (int i = 0; i < ja.length(); i++) {
                                JSONObject item = ja.getJSONObject(i);
                                FunimageBean n = new FunimageBean();
                                n.setTitle(item.getString("title"));
                                n.setThumburl(item.getString("thumburl"));
                                n.setUrl(item.getString("url"));

                                news.add(n);
                            }
                            funimgList.addAll(news);
                            mAdapter.notifyDataSetChanged();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
        queue.add(request);
    }
}










