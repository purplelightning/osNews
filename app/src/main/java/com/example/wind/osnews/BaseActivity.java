package com.example.wind.osnews;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.maning.themelibrary.SkinManager;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //设置主题
        SkinManager.onActivityCreateSetSkin(this);
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_base);
    }
}
