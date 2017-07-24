package com.example.wind.osnews.robot;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.wind.osnews.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wind on 17-7-22.
 */

public class RobotFragment extends Fragment {

    private ListView mMsgList;
    private ChatMessageAdapter mAdapter;
    private List<ChatMessage> mData;

    private EditText mInputMsg;
    private Button mSendMsg;

    private Handler mHandler = new Handler() {

        public void handleMessage(Message msg) {
            //等待接收,子线程完成数据的返回
            ChatMessage fromMessage = (ChatMessage) msg.obj;
            mData.add(fromMessage);
            mAdapter.notifyDataSetChanged();
            //报错原因是这里没有写!!!!
            mMsgList.setSelection(mData.size()-1);
        }
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_robot,container,false);

//        ActionBar actionBar=(AppCompatActivity)getActivity().getSupportActionBar();
//        actionBar.hide();

        mMsgList = (ListView) view.findViewById(R.id.id_listview_msgs);
        mInputMsg = (EditText) view.findViewById(R.id.id_input_msg);
        mSendMsg = (Button) view.findViewById(R.id.btn_send_msg);

        initData();
        //初始化事件
        initListener();

        return view;
    }

    private void initListener() {
        mSendMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String toMsg = mInputMsg.getText().toString().trim();
                if (TextUtils.isEmpty(toMsg)) {
                    Toast.makeText(getContext(), "发送消息不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }

                //把发送信息加入到数据列中
                ChatMessage toMessage=new ChatMessage();
                toMessage.setDate(new Date());
                toMessage.setMsg(toMsg);
                toMessage.setType(ChatMessage.Type.OUTCOMING);
                mData.add(toMessage);
                mAdapter.notifyDataSetChanged();

                mMsgList.setSelection(mData.size()-1);
                mInputMsg.setText("");//输入框文本清空

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        ChatMessage fromMessage = HttpUtils.
                                sendMessage(toMsg);
                        fromMessage.setDate(new Date());
                        fromMessage.setType(ChatMessage.Type.INCOMING);
                        fromMessage.setMsg(fromMessage.getMsg());
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                            }
                        });

                        Message message=new Message();
                        message.obj=fromMessage;
                        mHandler.sendMessage(message);

//                        Message m = Message.obtain();
//                        m.obj = fromMessage;
//                        mHandler.sendMessage(m);

                    }
                }).start();

            }
        });
    }

    private void initData() {
        mData= new ArrayList<>();
        mData.add(new ChatMessage("你好,机器鼠为您服务", ChatMessage.Type.INCOMING,
                new Date()));
//        mData.add(new ChatMessage("你好", ChatMessage.Type.OUTCOMING,
//                new Date()));
        mAdapter = new ChatMessageAdapter(getContext(), mData);

        mMsgList.setAdapter(mAdapter);
    }



}




