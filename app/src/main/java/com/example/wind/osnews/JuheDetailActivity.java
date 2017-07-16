package com.example.wind.osnews;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JuheDetailActivity extends AppCompatActivity {


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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juhedetail);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        String jimg = intent.getStringExtra("jimg");
        String jtitle = intent.getStringExtra("jtitle");

        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Glide.with(this).load(jimg).into(juhenewsImg);
        collapsingToolbar.setTitle(jtitle);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
