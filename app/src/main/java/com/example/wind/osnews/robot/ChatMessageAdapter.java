package com.example.wind.osnews.robot;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.wind.osnews.R;

import java.util.List;

/**
 * Created by wind on 17-7-21.
 */

public class ChatMessageAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private List<ChatMessage> mDatas;

    public ChatMessageAdapter(Context mContext, List<ChatMessage> mData){

        inflater=LayoutInflater.from(mContext);
        mDatas=mData;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {

        ChatMessage chatMessage=mDatas.get(position);
        if(chatMessage.getType()== ChatMessage.Type.INCOMING){
            return 0;
        }
        return 1;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ChatMessage chatMessage=mDatas.get(position);
        ViewHolder viewHolder=null;
        if(convertView==null){
            //通过itemType设置不同的布局
            if(getItemViewType(position)==0){
                convertView=inflater.inflate(R.layout.item_from_msg,parent,false);
                viewHolder=new ViewHolder();
//                viewHolder.mDate= (TextView) convertView.findViewById(R.id.id_from_msg_date);
                viewHolder.mMsg= (TextView) convertView.findViewById(R.id.id_from_msg_info);
            }else {
                convertView=inflater.inflate(R.layout.item_to_msg,parent,false);
                viewHolder=new ViewHolder();
//                viewHolder.mDate= (TextView) convertView.findViewById(R.id.id_to_msg_date);
                viewHolder.mMsg= (TextView) convertView.findViewById(R.id.id_to_msg_info);
            }
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        //设置数据
//        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        viewHolder.mDate.setText(df.format(chatMessage.getDate()));
        viewHolder.mMsg.setText(chatMessage.getMsg());

        return convertView;
    }

    private final class ViewHolder{
        TextView mDate;
        TextView mMsg;
    }

}








