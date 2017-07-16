package com.example.wind.osnews.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.wind.osnews.Bean.JuheBean;
import com.example.wind.osnews.Bean.JuheNewsType;
import com.example.wind.osnews.R;
import com.example.wind.osnews.adapter.JuhenewsAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wind on 17-7-15.
 */

public class JuheNewsFragment extends Fragment {

    private List<JuheBean.ResultBean.DataBean> jBeanList;
    private JuhenewsAdapter mAdapter;


    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_juhenews, container, false);

        RecyclerView recyclerView= (RecyclerView) view.findViewById(R.id.jrecycler_view);

        jBeanList=new ArrayList<>();
        initData();

        mAdapter=new JuhenewsAdapter(getContext(),jBeanList);
        recyclerView.setAdapter(mAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mAdapter.setOnItemClickListener(new JuhenewsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
//              用浏览器打开对应item
                String url=jBeanList.get(position).getUrl();
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        return view;
    }

    private void initData() {
        JuheNewsType nt= (JuheNewsType) getArguments().getSerializable("type");
        //创建请求队列
        RequestQueue queue= Volley.newRequestQueue(getActivity());
        StringRequest request=new StringRequest(
                Request.Method.GET,
                nt.getUrl(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        System.out.println(s);
                        try {
                            JSONObject job = new JSONObject(s);
                            if (job.getString("reason").equals("成功的返回")) {
                                List<JuheBean.ResultBean.DataBean> news = new ArrayList<>();
                                JSONObject result = job.getJSONObject("result");
                                JSONArray ja = result.getJSONArray("data");
                                for (int i = 0; i < ja.length(); i++) {
                                    JSONObject item = ja.getJSONObject(i);
                                    JuheBean.ResultBean.DataBean n = new JuheBean.ResultBean.DataBean();
                                    n.setTitle(item.getString("title"));
                                    n.setAuthor_name(item.getString("author_name"));
                                    n.setDate(item.getString("date"));
                                    n.setThumbnail_pic_s(item.getString("thumbnail_pic_s"));
                                    n.setUrl(item.getString("url"));

                                    news.add(n);
                                }
                                jBeanList.addAll(news);
                                mAdapter.notifyDataSetChanged();
                            }
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

    //其他的都与普通的recyclerview写法一样,只有数据Bean不一样,现在已经可以自己造数据Bean了,最后只需要联网获取json
    // 数据添加到数组中就可以了
//    private void initData() {
//        JuheBean.ResultBean.DataBean bean=new JuheBean.ResultBean.DataBean();
//        bean.setTitle("我要睡觉了");
//        bean.setAuthor_name("十二月魔");
//        bean.setCategory("1");
//        bean.setDate("2017-7-14");
//        bean.setThumbnail_pic_s("333");
//        bean.setThumbnail_pic_s02("333");
//        bean.setThumbnail_pic_s03("333");
//        bean.setUniquekey("1");
//        bean.setUrl("333");
//
//        for (int i = 0; i < 10; i++) {
//            jBeanList.add(bean);
//        }
//
//    }



}
