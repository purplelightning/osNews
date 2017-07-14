package com.example.wind.osnews;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.wind.osnews.fragment.DiscoverFragment;
import com.example.wind.osnews.fragment.HomeFragment;
import com.example.wind.osnews.fragment.MineFragment;
import com.example.wind.osnews.fragment.TweetFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

//fragmentTransaction变量定义为全局变量，导致只能commit一次，所以只要将FragmentTransaction变量定义为局部变量即可。

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.home)
    RadioButton home;
    @BindView(R.id.tweet)
    RadioButton tweet;
    @BindView(R.id.discover)
    RadioButton discover;
    @BindView(R.id.mine)
    RadioButton mine;
    @BindView(R.id.login)
    RadioButton login;
    private Fragment f1, f2, f3, f4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initFragment();

        RadioGroup rg = (RadioGroup) findViewById(R.id.rg_tabs);
        changeImageSize();
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

                switch (checkedId) {
                    case R.id.home:
                        ft.show(f1).hide(f2).hide(f3).hide(f4).commit();
                        break;
                    case R.id.tweet:
                        ft.show(f2).hide(f1).hide(f3).hide(f4).commit();
                        break;
                    case R.id.discover:
                        ft.show(f3).hide(f2).hide(f1).hide(f4).commit();
                        break;
                    case R.id.mine:
                        ft.show(f4).hide(f2).hide(f3).hide(f1).commit();
                        break;
                    case R.id.login:
                        Toast.makeText(MainActivity.this, "YYYY", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    private void changeImageSize() {
        //定义底部标签图片大小
        Drawable drawableHome = getResources().getDrawable(R.drawable.tab_home_bg);
        drawableHome.setBounds(0, 0, 45, 45);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        home.setCompoundDrawables(null, drawableHome, null, null);//只放上面

        Drawable drawableTweet = getResources().getDrawable(R.drawable.tab_tweet_bg);
        drawableTweet.setBounds(0, 0, 45, 45);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        tweet.setCompoundDrawables(null, drawableTweet, null, null);//只放上面

        Drawable drawableDiscover = getResources().getDrawable(R.drawable.tab_discover_bg);
        drawableDiscover.setBounds(0, 0, 45, 45);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        discover.setCompoundDrawables(null, drawableDiscover, null, null);//只放上面

        Drawable drawableMine = getResources().getDrawable(R.drawable.tab_mine_bg);
        drawableMine.setBounds(0, 0, 45, 45);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        mine.setCompoundDrawables(null, drawableMine, null, null);//只放上面

        Drawable drawableLogin = getResources().getDrawable(R.drawable.ic_tweet_select_picture_selected);
        drawableLogin.setBounds(0, 8, 74, 84);//第一0是距左右边距离，第二0是距上下边距离，第三69长度,第四宽度
        login.setCompoundDrawables(null, drawableLogin, null, null);//只放上面
    }

    private void initFragment() {
        f1 = new HomeFragment();
        f2 = new TweetFragment();
        f3 = new DiscoverFragment();
        f4 = new MineFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, f1, "home")
                .add(R.id.container, f2, "tweet")
                .add(R.id.container, f3, "discover")
                .add(R.id.container, f4, "mine")
                .commit();
        getSupportFragmentManager().beginTransaction()
                .hide(f2)
                .hide(f3)
                .hide(f4)
                .commit();
    }

//    @Override
//    protected void onPostCreate(Bundle savedInstanceState) {
//        super.onPostCreate(savedInstanceState);
//        mDrawerToggle.syncState();
//    }
}

