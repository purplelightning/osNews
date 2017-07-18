package com.example.wind.osnews;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.wind.osnews.Bean.Detail;
import com.example.wind.osnews.Bean.DetailComment;
import com.example.wind.osnews.Bean.QuestionDetailBean;
import com.example.wind.osnews.Utils.StringUtils;
import com.example.wind.osnews.widget.TweetTextView;
import com.itheima.retrofitutils.ItheimaHttp;
import com.itheima.retrofitutils.Request;
import com.itheima.retrofitutils.listener.HttpResponseListener;
import com.maning.themelibrary.SkinManager;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.Headers;
import retrofit2.Call;

public class QuestionDetailActivity extends BaseActivity {

//    String dUrl = "http://www.oschina.net/action/apiv2/question?id=";
    @BindView(R.id.wv_que_detail_web)
    WebView wvQueDetailWeb;
    @BindView(R.id.tv_que_detail_pub_date)
    TextView tvQueDetailPubDate;
    @BindView(R.id.tv_que_comment_count)
    TextView tvQueCommentCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_detail);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        int id = intent.getIntExtra("id", 0);


        Request request = ItheimaHttp.newGetRequest("action/apiv2/question?id=" + id);//apiUrl格式："xxx/xxxxx"
        Call call = ItheimaHttp.send(request, new HttpResponseListener<QuestionDetailBean>() {
            @Override
            public void onResponse(QuestionDetailBean bean, Headers headers) {

                tvQueDetailPubDate.setText(StringUtils.friendly_time3(bean.getResult().getPubDate()));

                tvQueCommentCount.setText(bean.getResult().getCommentCount() + "");
                //对WebView进行设置
//                WebSettings webSettings = wvNewDetailWeb.getSettings();//获取webview设置属性
//                //把html中的内容放大webview等宽的一列中
//                webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
//                webSettings.setJavaScriptEnabled(true);//支持js
//                webSettings.setBuiltInZoomControls(true); // 显示放大缩小
//                webSettings.setSupportZoom(true); // 可以缩放

                wvQueDetailWeb.getSettings().setDefaultTextEncodingName("UTF-8");
                wvQueDetailWeb.loadDataWithBaseURL(null, getNewContent(bean.getResult().getBody()),
                        "text/html", "charset=UTF-8", null);

                //WebView夜间模式
                wvQueDetailWeb.setWebViewClient(new WebViewClient() {

                    @Override
                    public void onPageFinished(WebView view, String url) {
                        super.onPageFinished(view, url);
                        //设置webView,这里是设置夜间模式的颜色
                        String backgroudColor = "#232736";
                        String fontColor = "#626f9b";
                        String urlColor = "#9AACEC";
                        SkinManager.setColorWebView(wvQueDetailWeb, backgroudColor, fontColor, urlColor);
                    }

                });

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
