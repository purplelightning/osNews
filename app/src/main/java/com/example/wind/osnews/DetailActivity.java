package com.example.wind.osnews;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.wind.osnews.Bean.Detail;
import com.example.wind.osnews.Bean.DetailComment;
import com.example.wind.osnews.Utils.StringUtils;
import com.example.wind.osnews.widget.FloorView;
import com.example.wind.osnews.widget.TweetTextView;
import com.itheima.retrofitutils.ItheimaHttp;
import com.itheima.retrofitutils.Request;
import com.itheima.retrofitutils.listener.HttpResponseListener;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.Headers;
import retrofit2.Call;

public class DetailActivity extends BaseActivity {

    @BindView(R.id.tv_new_detail_name)
    TextView tvNewDetailName;
    @BindView(R.id.tv_new_detail_pub_date)
    TextView tvNewDetailPubDate;
    @BindView(R.id.wv_new_detail_web)
    WebView wvNewDetailWeb;
    @BindView(R.id.tv_new_detail_soft_title)
    TextView tvNewDetailSoftTitle;
    @BindView(R.id.ll_detail_about_softs)
    LinearLayout llDetailAboutSofts;
    @BindView(R.id.tv_new_detail_related_title)
    TextView tvNewDetailRelatedTitle;
    @BindView(R.id.ll_new_detail_related_layout)
    LinearLayout llNewDetailRelatedLayout;
    @BindView(R.id.tv_new_detail_comment)
    TextView tvNewDetailComment;
    @BindView(R.id.iv_avatar)
    CircleImageView ivAvatar;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_pub_time)
    TextView tvPubTime;
    @BindView(R.id.btn_comment)
    ImageView btnComment;
    @BindView(R.id.iv_best_answer)
    ImageView ivBestAnswer;
    @BindView(R.id.ly_refers)
    FloorView lyRefers;
    @BindView(R.id.tv_content)
    TweetTextView tvContent;
    @BindView(R.id.lay_refer)
    LinearLayout layRefer;
    @BindView(R.id.line)
    View line;
    @BindView(R.id.ll_new_detail_commnet_layout)
    LinearLayout llNewDetailCommnetLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);

        Request request = ItheimaHttp.newGetRequest("action/apiv2/news?id=" + id);//apiUrl格式："xxx/xxxxx"
        Call call = ItheimaHttp.send(request, new HttpResponseListener<Detail>() {
            @Override
            public void onResponse(Detail bean, Headers headers) {

                tvNewDetailName.setText(bean.getResult().getTitle());
                tvNewDetailPubDate.setText(StringUtils.friendly_time3(bean.getResult().getPubDate()));

                tvNewDetailComment.setText("评论("+bean.getResult().getCommentCount()+")");
                //对WebView进行设置
//                WebSettings webSettings = wvNewDetailWeb.getSettings();//获取webview设置属性
//                //把html中的内容放大webview等宽的一列中
//                webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
//                webSettings.setJavaScriptEnabled(true);//支持js
//                webSettings.setBuiltInZoomControls(true); // 显示放大缩小
//                webSettings.setSupportZoom(true); // 可以缩放

                wvNewDetailWeb.getSettings().setDefaultTextEncodingName("UTF-8");
                wvNewDetailWeb.loadDataWithBaseURL(null, getNewContent(bean.getResult().getBody()),
                        "text/html", "charset=UTF-8", null);

                List<Detail.ResultBean.AboutsBean> abouts = bean.getResult().getAbouts();
                for (int i = 0; i < abouts.size(); i++) {

                    //相关软件
                    View view = View.inflate(DetailActivity.this, R.layout.item_about_soft, null);
                    TextView mTextView= (TextView) view.findViewById(R.id.tv_item_about_safe_name);
                    mTextView.setText(abouts.get(i).getTitle());
                    llDetailAboutSofts.addView(view);//添加的view应该是item

                    //相关推荐
                    View view1=View.inflate(DetailActivity.this,R.layout.item_about_recom,null);
                    TextView recom_title= (TextView) view1.findViewById(R.id.tv_item_about_recom_name);
                    TextView recom_count= (TextView) view1.findViewById
                            (R.id.tv_item_about_recom_comment_count);
                    recom_title.setText(abouts.get(i).getTitle());
                    recom_count.setText(abouts.get(i).getCommentCount()+"");
                    llNewDetailRelatedLayout.addView(view1);
                }


            }
        });
        request = ItheimaHttp.newGetRequest("action/apiv2/comment?parts=refer,reply&sourceId="+id +
                "&type=6");//apiUrl格式："xxx/xxxxx"
        call = ItheimaHttp.send(request, new HttpResponseListener<DetailComment>() {
            @Override
            public void onResponse(DetailComment bean,Headers headers) {

                CircleImageView ivatar;
                TextView cAurthor;
                TextView cTime;
                TextView thumbCount;
                TweetTextView cContent;

                List<DetailComment.ResultBean.ItemsBean> itemsData=bean.getItemDatas();
                for (int i = 0; i < itemsData.size(); i++) {
                    View view2=View.inflate(DetailActivity.this,R.layout.lay_comment_item_ex,null);
                    ivatar= (CircleImageView) view2.findViewById(R.id.iv_avatar);
                    cAurthor= (TextView) view2.findViewById(R.id.tv_name);
                    cTime= (TextView) view2.findViewById(R.id.tv_pub_time);
                    cContent= (TweetTextView) view2.findViewById(R.id.tv_content);
//                    thumbCount= (TextView) view2.findViewById(R.id.thumb_count);

                    Glide.with(DetailActivity.this).load(itemsData.get(i).getAuthorPortrait()).
                            into(ivatar);
                    cAurthor.setText(itemsData.get(i).getAuthor());
                    cTime.setText(StringUtils.friendly_time3(itemsData.get(i).getPubDate()));
//                    thumbCount.setText(itemsData.get(i).getVoteState()+"");
                    cContent.setText(itemsData.get(i).getContent());

                    llNewDetailCommnetLayout.addView(view2);
                }


            }
        });




    }


    /**
     * 将html文本内容中包含img标签的图片，宽度变为屏幕宽度，高度根据宽度比例自适应
     **/
    public static String getNewContent(String htmltext) {
        try {
            Document doc = Jsoup.parse(htmltext);
            Elements elements = doc.getElementsByTag("img");
            for (Element element : elements) {
                element.attr("width", "100%").attr("height", "auto");
            }

            return doc.toString();
        } catch (Exception e) {
            return htmltext;
        }
    }
}

















