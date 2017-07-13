package com.example.wind.osnews.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wind.osnews.Bean.BlogBean;
import com.example.wind.osnews.R;
import com.example.wind.osnews.Utils.StringUtils;

import org.itheima.recycler.adapter.BaseLoadMoreRecyclerAdapter;
import org.itheima.recycler.header.RecyclerViewHeader;
import org.itheima.recycler.viewholder.BaseRecyclerViewHolder;
import org.itheima.recycler.widget.ItheimaRecyclerView;
import org.itheima.recycler.widget.PullToLoadMoreRecyclerView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by wind on 17-7-12.
 */

public class BlogFragment extends Fragment {

    PullToLoadMoreRecyclerView pullToLoadMoreRecyclerView;
    SwipeRefreshLayout mSwipeRefreshLayout;
    ItheimaRecyclerView mRecyclerView;

    String blogListUrl = "action/apiv2/blog?catalog=1&nextPageToken=";
    static String blogDetailUrl = "";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blog, container, false);

        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_layout);
        mRecyclerView = (ItheimaRecyclerView) view.findViewById(R.id.recycler_view);

        RecyclerViewHeader header = (RecyclerViewHeader) view.findViewById(R.id.recycler_header);
        mRecyclerView = (ItheimaRecyclerView) view.findViewById(R.id.recycler_view);
        header.attachTo(mRecyclerView);

        RadioGroup rg = (RadioGroup) view.findViewById(R.id.brg_tabs);


        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.new_recom_blog:
                        blogListUrl = "action/apiv2/blog?catalog=1&nextPageToken=";
                        break;
                    case R.id.hot_blog:
                        blogListUrl = "action/apiv2/blog?catalog=2&nextPageToken=";
                        break;
                    case R.id.new_blog:
                        blogListUrl = "action/apiv2/blog?catalog=3&nextPageToken=";
                        break;
                }
                initData();
            }

        });

        initData();

        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        return view;
    }

    private void initData() {

        pullToLoadMoreRecyclerView = new PullToLoadMoreRecyclerView<BlogBean>(mSwipeRefreshLayout,
                mRecyclerView, MyRecyclerViewHolder.class) {
            @Override
            public int getItemResId() {
                //recylerview item资源id
                return R.layout.item_list_blog;
            }

            @Override
            public String getApi() {

                //接口
                return blogListUrl;
            }

            //是否加载更多的数据，根据业务逻辑自行判断，true表示有更多的数据，false表示没有更多的数据，如果不需要监听可以不重写该方法
            @Override
            public boolean isMoreData(BaseLoadMoreRecyclerAdapter.LoadMoreViewHolder holder) {
                System.out.println("isMoreData" + holder);

                return true;
            }
        };
        //开始请求
        pullToLoadMoreRecyclerView.requestData();

    }

    public static class MyRecyclerViewHolder extends BaseRecyclerViewHolder
            <BlogBean.ResultBean.ItemsBean> {
        @BindView(R.id.blog_title)
        TextView blogTitle;
        @BindView(R.id.blog_content)
        TextView blogContent;
        @BindView(R.id.tv_aurthor)
        TextView tvAurthor;
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.tv_comment_count)
        TextView tvCommentCount;
        @BindView(R.id.tv_view_count)
        TextView tvViewCount;

        //换成你布局文件中的id

        public MyRecyclerViewHolder(ViewGroup parentView, int itemResId) {
            super(parentView, itemResId);
        }

        /**
         * 绑定数据的方法，在mData获取数据（mData声明在基类中）
         */
        @Override

        public void onBindRealData() {
            blogTitle.setText(mData.getTitle());
            blogContent.setText(mData.getBody());
            tvAurthor.setText(mData.getAuthor());
            tvTime.setText(StringUtils.friendly_time3(mData.getPubDate()));
            tvCommentCount.setText(mData.getCommentCount() + "");
            tvViewCount.setText(mData.getViewCount() + "");
        }

        /**
         * 给按钮添加点击事件（button改成你要添加点击事件的id）
         *
         * @param v
         */
        @OnClick({R.id.blog_content, R.id.blog_title, R.id.tv_aurthor})//绑定多个id,用大括号
        public void click(View v) {
            switch (v.getId()) {
                case R.id.blog_content:
                case R.id.tv_aurthor:
                case R.id.blog_title:
                    Intent nIntent = new Intent(Intent.ACTION_VIEW);
                    String questionDetailUrl = mData.getHref();
                    nIntent.setData(Uri.parse(questionDetailUrl));
                    mContext.startActivity(nIntent);//用context在static类中开启活动
                    break;

            }
        }

    }
}
