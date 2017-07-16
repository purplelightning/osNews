package com.example.wind.osnews.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.wind.osnews.Bean.FunimageBean;
import com.example.wind.osnews.Bean.JokeBean;
import com.example.wind.osnews.R;

import java.util.List;

/**
 * Created by wind on 17-7-15.
 */

public class FunImageAdapter extends RecyclerView.Adapter<FunImageAdapter.JuViewHolder> {

    private List<FunimageBean> jList;
    private Context mContext;

    /*
        监听器初始化
    */
    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }

    private OnItemClickListener mListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public FunImageAdapter(Context context, List<FunimageBean> list){
        mContext=context;
        jList=list;
    }

    static class JuViewHolder extends RecyclerView.ViewHolder {

        TextView titleText;
        ImageView fImg;

        public JuViewHolder(View itemView) {
            super(itemView);
            titleText= (TextView) itemView.findViewById(R.id.fimg_title);
            fImg= (ImageView) itemView.findViewById(R.id.fimg_img);

        }
    }


    @Override
    public JuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.item_list_funimage,
                parent,false);
        return new JuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final JuViewHolder holder, final int position) {
        FunimageBean data=jList.get(position);
        holder.titleText.setText(data.getTitle());
        Glide.with(mContext).load(data.getThumburl()).into(holder.fImg);

        //监听器回调
        if (mListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onItemClick(holder.itemView, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return jList.size();
    }
}
