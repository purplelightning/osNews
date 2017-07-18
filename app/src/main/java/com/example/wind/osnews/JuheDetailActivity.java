package com.example.wind.osnews;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;


public class JuheDetailActivity extends BaseActivity {


    @BindView(R.id.juhenews_img)
    ImageView juhenewsImg;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.appBar)
    AppBarLayout appBar;
    @BindView(R.id.juhedetail_content)
    TextView juhedetailContent;

//    String url = "http://www.jcodecraeer.com/plus/list.php?tid=18&TotalResult=1415&PageNo=1";
//    String url=http://mini.eastday.com/mobile/170717113659748.html
    String url="";
    String content = "";
    private String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.71 Safari/537.36";

    private String curPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juhedetail);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        String jimg = intent.getStringExtra("jimg");
        String jtitle = intent.getStringExtra("jtitle");

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Glide.with(this).load(jimg).into(juhenewsImg);
        collapsingToolbar.setTitle(jtitle);

        //开启子线程使用Jsoup抓取网页上的文字
        new Thread(runnable).start();

    }


    Runnable runnable = new Runnable() {
        @Override
        public void run() {

            Connection conn = Jsoup.connect(url);
            conn.header("User-Agent", userAgent);
            Document doc = null;
            try {
                doc = conn.get();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Elements links=doc.getElementsByClass("section txt");
            for(Element link:links){
                String abc=link.text();
                content+=abc+"\n";
            }





            /*
                Jsoup测试,关键是正确找到节点
            */
            /*Elements links = doc.select("div.archive-detail");

            for(Element link:links){
                Element ll=link.getElementsByTag("p").first();
                String abc=ll.text();
                content+=abc+"\n"+"\n";
            }*/

            /*Elements ll=links.get(0).getElementsByTag("p");
            String abc=ll.get(0).text();
            content+=abc+"\n"+"\n";
            content+="llllll";*/

            // 执行完毕后给handler发送一个空消息
            Message message = new Message();
//            message.arg1 = Integer.parseInt(curPage);
            handler.sendMessage(message);
        }

    };

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            //收到消息后执行handler
            juhedetailContent.setText(content);
        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}





