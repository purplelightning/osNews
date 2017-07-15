package com.example.wind.osnews.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.wind.osnews.Bean.JuheBean;
import com.example.wind.osnews.R;

import java.util.List;

/**
 * Created by wind on 17-7-15.
 */

public class JuhenewsAdapter extends RecyclerView.Adapter<JuhenewsAdapter.JuViewHolder> {

    private List<JuheBean.ResultBean.DataBean> jList;
    private Context mContext;

    public JuhenewsAdapter(Context context,List<JuheBean.ResultBean.DataBean> list){
        mContext=context;
        jList=list;
    }

    static class JuViewHolder extends RecyclerView.ViewHolder {

        ImageView imageIcon;
        TextView titleText;
        TextView sourceText;
        TextView timeText;

        public JuViewHolder(View itemView) {
            super(itemView);
            imageIcon= (ImageView) itemView.findViewById(R.id.j_img);
            titleText= (TextView) itemView.findViewById(R.id.j_title);
            sourceText= (TextView) itemView.findViewById(R.id.j_description);
            timeText= (TextView) itemView.findViewById(R.id.j_time);

        }
    }


    @Override
    public JuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.item_list_juhenews,
                parent,false);
        return new JuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(JuViewHolder holder, int position) {
        JuheBean.ResultBean.DataBean data=jList.get(position);
        holder.titleText.setText(data.getTitle());
        holder.sourceText.setText(data.getAuthor_name());
        Glide.with(mContext).load(R.drawable.cat).into(holder.imageIcon);
        holder.timeText.setText(data.getDate());
    }

    @Override
    public int getItemCount() {
        return jList.size();
    }
}
