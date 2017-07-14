package com.example.wind.osnews.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wind.osnews.Bean.BannerBean;
import com.example.wind.osnews.Bean.NewsBean;
import com.example.wind.osnews.DetailActivity;
import com.example.wind.osnews.R;
import com.example.wind.osnews.Utils.StringUtils;
import com.itheima.loopviewpager.LoopViewPager;
import com.itheima.retrofitutils.ItheimaHttp;
import com.itheima.retrofitutils.L;
import com.itheima.retrofitutils.Request;
import com.itheima.retrofitutils.listener.HttpResponseListener;

import org.itheima.recycler.adapter.BaseLoadMoreRecyclerAdapter;
import org.itheima.recycler.header.RecyclerViewHeader;
import org.itheima.recycler.listener.ItemClickSupport;
import org.itheima.recycler.viewholder.BaseRecyclerViewHolder;
import org.itheima.recycler.widget.ItheimaRecyclerView;
import org.itheima.recycler.widget.PullToLoadMoreRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.internal.Utils;
import okhttp3.Headers;
import retrofit2.Call;

import static android.R.attr.delay;

/**
 * Created by wind on 17-7-12.
 */

public class NewsFragment extends Fragment {

    ItheimaRecyclerView recyclerView;
    RecyclerViewHeader recyclerHeader;
    PullToLoadMoreRecyclerView pullToLoadMoreRecyclerView;
    SwipeRefreshLayout mSwipeRefreshLayout;

    private LoopViewPager loopViewPager;
    List<String> imageLists = new ArrayList<String>();
    List<String> textLists = new ArrayList<String>();


    private int state = 0;
    //下拉刷新
    private static final int STATE_REFRESH = 1;
    //加载更多
    private static final int STATE_MORE = 2;
    private String nextPageToken = "";
    private NewsBean mNewsBean;

    //存储要显示的item值,用于点击事件
    List<NewsBean.ResultBean.ItemsBean> itemsBeen = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);

        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_layout);

        RecyclerViewHeader header = (RecyclerViewHeader) view.findViewById(R.id.recycler_header);
        recyclerView = (ItheimaRecyclerView) view.findViewById(R.id.recycler_view);
        header.attachTo(recyclerView);

        loopViewPager = (LoopViewPager) view.findViewById(R.id.lvp_pager);

        initData();

        initBanner();

        //设置监听
        pullToLoadMoreRecyclerView.setLoadingDataListener(new PullToLoadMoreRecyclerView.
                LoadingDataListener<NewsBean>() {

            @Override
            public void onRefresh() {
                //监听下啦刷新，如果不需要监听可以不重新该方法
                L.i("setLoadingDataListener onRefresh");

                state = STATE_REFRESH;
                Toast.makeText(getContext(),"下拉刷新",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStart() {
                //监听http请求开始，如果不需要监听可以不重新该方法
                L.i("setLoadingDataListener onStart");
            }

            @Override
            public void onSuccess(NewsBean newsBean, Headers headers) {
                //监听http请求成功，如果不需要监听可以不重新该方法
                L.i("setLoadingDataListener onSuccess: " + newsBean);

                mNewsBean=newsBean;

                //当前的item值
                List<NewsBean.ResultBean.ItemsBean> itemDatas=newsBean.getItemDatas();
                for(NewsBean.ResultBean.ItemsBean itemData:itemDatas){
                    itemsBeen.add(itemData);
                }
            }

//            @Override
//            public void onFailure() {
//                //监听http请求失败，如果不需要监听可以不重新该方法
//                L.i("setLoadingDataListener onFailure");
//            }
        });

        ItemClickSupport itemClickSupport = new ItemClickSupport(recyclerView);
        //点击事件
        itemClickSupport.setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
//                Toast.makeText(recyclerView.getContext(), "The title of the item clicked is "
//                                +itemsBeen.get(position).getTitle(),
//                        Toast.LENGTH_SHORT).show();
                int id=itemsBeen.get(position).getId();
                Intent intent=new Intent(getContext(), DetailActivity.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });

        //开始请求
        pullToLoadMoreRecyclerView.requestData();

//        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),
//                DividerItemDecoration.VERTICAL));

        return view;
    }

    private void initBanner() {
        Request request = ItheimaHttp.newGetRequest("action/apiv2/banner?catalog=1");//apiUrl格式："xxx/xxxxx"
        Call call = ItheimaHttp.send(request, new HttpResponseListener<BannerBean>() {
            @Override
            public void onResponse(BannerBean bannerBean, Headers headers) {
                imageLists.clear();//初始化清空
                textLists.clear();
                List<BannerBean.ResultBean.ItemsBean> itemDatas = bannerBean.getItemDatas();
                for (int i = 0; i < itemDatas.size(); i++) {
                    imageLists.add(itemDatas.get(i).getImg());
                    textLists.add(itemDatas.get(i).getName());
                }
                loopViewPager.setImgData(imageLists);
                loopViewPager.setTitleData(textLists);
                loopViewPager.start();

            }
        });
    }


    private void initData() {
        pullToLoadMoreRecyclerView = new PullToLoadMoreRecyclerView<NewsBean>
                (mSwipeRefreshLayout, recyclerView, MyRecyclerViewHolder.class) {
            @Override
            public int getItemResId() {
                //recylerview item资源id
                return R.layout.item_list_news;
            }

            @Override
            public String getApi() {
                String url = "action/apiv2/news?pageToken=";
                //判断是第一次请求,下拉刷新还是加载更多
                switch (state) {
                    case STATE_REFRESH:
                        break;
                    //需要服务器实时更新的nextPageToken
                    case STATE_MORE:
                        nextPageToken = mNewsBean.getResult().getNextPageToken();
                        url += NewsFragment.this.nextPageToken;
                        break;
                }
                //接口
                return url;
            }

            //是否加载更多的数据，根据业务逻辑自行判断，true表示有更多的数据，false表示没有更多的数据，如果不需要监听可以不重写该方法
            @Override
            public boolean isMoreData(BaseLoadMoreRecyclerAdapter.LoadMoreViewHolder holder) {
                System.out.println("isMoreData" + holder);

                state = STATE_MORE;

                Toast.makeText(getContext(),"加载更多",Toast.LENGTH_SHORT).show();

                return true;
            }
        };
    }


    public static class MyRecyclerViewHolder extends BaseRecyclerViewHolder<NewsBean.
            ResultBean.ItemsBean> {
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_description)
        TextView tvDescription;
        @BindView(R.id.ll_title)
        LinearLayout llTitle;
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.tv_comment_count)
        TextView tvCommentCount;
        @BindView(R.id.iv_info_comment)
        ImageView ivInfoComment;
        //换成你布局文件中的id

        public MyRecyclerViewHolder(ViewGroup parentView, int itemResId) {
            super(parentView, itemResId);
        }

        /**
         * 绑定数据的方法，在mData获取数据（mData声明在基类中）
         */
        @Override
        public void onBindRealData() {
            tvTitle.setText(mData.getTitle());
            tvDescription.setText(mData.getBody());
            tvTime.setText(StringUtils.friendly_time3(mData.getPubDate()));
            tvCommentCount.setText(mData.getCommentCount() + "");
        }


        /**
         * 给按钮添加点击事件（button改成你要添加点击事件的id）
         *
         * @param v
         */
//        @OnClick(R.id.button)
//        public void click(View v) {
//        }
    }

}
