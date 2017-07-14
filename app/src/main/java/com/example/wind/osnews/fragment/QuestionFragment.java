package com.example.wind.osnews.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.wind.osnews.Bean.QuestionBean;
import com.example.wind.osnews.R;
import com.example.wind.osnews.Utils.StringUtils;

import org.itheima.recycler.adapter.BaseLoadMoreRecyclerAdapter;
import org.itheima.recycler.viewholder.BaseRecyclerViewHolder;
import org.itheima.recycler.widget.ItheimaRecyclerView;
import org.itheima.recycler.widget.PullToLoadMoreRecyclerView;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by wind on 17-7-12.
 */
//问答:http://www.oschina.net/action/apiv2/question
public class QuestionFragment extends Fragment {

    String url = "action/apiv2/question";

    PullToLoadMoreRecyclerView pullToLoadMoreRecyclerView;
    SwipeRefreshLayout mSwipeRefreshLayout;
    ItheimaRecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question, container, false);

        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_layout);
        mRecyclerView = (ItheimaRecyclerView) view.findViewById(R.id.recycler_view);

        initData();


        //开始请求
        pullToLoadMoreRecyclerView.requestData();

//        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));

        return view;
    }

    private void initData() {

        pullToLoadMoreRecyclerView = new PullToLoadMoreRecyclerView<QuestionBean>(mSwipeRefreshLayout, mRecyclerView, MyRecyclerViewHolder.class) {
            @Override
            public int getItemResId() {
                //recylerview item资源id
                return R.layout.item_list_question;
            }

            @Override
            public String getApi() {
                //接口
                return url;
            }

            //是否加载更多的数据，根据业务逻辑自行判断，true表示有更多的数据，false表示没有更多的数据，如果不需要监听可以不重写该方法
            @Override
            public boolean isMoreData(BaseLoadMoreRecyclerAdapter.LoadMoreViewHolder holder) {
                System.out.println("isMoreData" + holder);

                return true;
            }
        };
    }

    public static class MyRecyclerViewHolder extends BaseRecyclerViewHolder
            <QuestionBean.ResultBean.ItemsBean> {
        @BindView(R.id.q_image)
        CircleImageView qImage;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_content)
        TextView tvContent;
        @BindView(R.id.tv_author)
        TextView tvAuthor;
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.comment_count)
        TextView commentCount;
        //换成你布局文件中的id

        public MyRecyclerViewHolder(ViewGroup parentView, int itemResId) {
            super(parentView, itemResId);
        }

        /**
         * 绑定数据的方法，在mData获取数据（mData声明在基类中）
         */
        @Override

        public void onBindRealData() {
            Glide.with(mContext).load(mData.getAuthorPortrait()).into(qImage);
            tvTitle.setText(mData.getTitle());
            tvContent.setText(mData.getBody());
            tvAuthor.setText(mData.getAuthor());
            tvTime.setText(StringUtils.friendly_time3(mData.getPubDate()));
            commentCount.setText(mData.getCommentCount()+"");
        }

        /**
         * 给按钮添加点击事件（button改成你要添加点击事件的id）
         * @param v
         */
        @OnClick(R.id.tv_content)
        public void click(View v) {
            switch (v.getId()){
                case R.id.tv_content:

            }
        }

    }
}









