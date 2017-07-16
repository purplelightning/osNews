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
import com.example.wind.osnews.Bean.JokeBean;
import com.example.wind.osnews.Bean.JuheBean;
import com.example.wind.osnews.R;

import java.util.List;

/**
 * Created by wind on 17-7-15.
 */

public class JokeAdapter extends RecyclerView.Adapter<JokeAdapter.JuViewHolder> {

    private List<JokeBean> jList;
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

    public JokeAdapter(Context context, List<JokeBean> list){
        mContext=context;
        jList=list;
    }

    static class JuViewHolder extends RecyclerView.ViewHolder {

        TextView titleText;
        TextView contentText;

        public JuViewHolder(View itemView) {
            super(itemView);
            titleText= (TextView) itemView.findViewById(R.id.joke_title);
            contentText= (TextView) itemView.findViewById(R.id.joke_content);

        }
    }


    @Override
    public JuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.item_list_joke,
                parent,false);
        return new JuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final JuViewHolder holder, final int position) {
        JokeBean data=jList.get(position);
        holder.titleText.setText(data.getTitle());
        Spanned content= Html.fromHtml(data.getContent());
        holder.contentText.setText(content);

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
