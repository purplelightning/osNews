package com.example.wind.osnews.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wind.osnews.R;

/**
 * Created by wind on 17-7-12.
 */
//问答:http://www.oschina.net/action/apiv2/question
public class QuestionFragment extends Fragment{

    String url="action/apiv2/question";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_question,container,false);

        initData();

        return view;
    }

    private void initData() {

    }
}
