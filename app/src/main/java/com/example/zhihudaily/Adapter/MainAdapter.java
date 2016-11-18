package com.example.zhihudaily.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zhihudaily.Bean.NewMessage;
import com.example.zhihudaily.InterFace.onMainRecyclerViewItemClickListner;
import com.example.zhihudaily.R;

import java.util.List;

/**
 * Created by 教科书式的机智少年 on 2016/11/16.
 */

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener{

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_NORMAL = 1;
    private static final int TYPE_FOOTER = 2;
    private View headerView;
    private View footerView;
    private onMainRecyclerViewItemClickListner onItemClickListener = null;
    private Context context;
    private List<NewMessage.StoriesBean> stories;


    public MainAdapter (Context context, List<NewMessage.StoriesBean> stories){
        this.context = context;
        this.stories = stories;
    }

    public void setOnItemClickListener(onMainRecyclerViewItemClickListner onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    public void upData(List<NewMessage.StoriesBean> data){
        stories.clear();
        notifyDataSetChanged();
        stories.addAll(data);
        notifyDataSetChanged();
    }
    public void addMore(List<NewMessage.StoriesBean> more){
        stories.addAll(more);
        notifyDataSetChanged();
    }
    public View getHeaderView(){
        return headerView;
    }
    public void setHeaderView(View view){
        headerView = view;
    }
    public View getFooterView(){
        return footerView;
    }
    public void setFooterView(View view){
        footerView = view;
    }

    @Override
    public void onClick(View v) {
        onItemClickListener.onItemClick(v,(NewMessage.StoriesBean)v.getTag());
    }

    @Override
    public int getItemViewType(int position) {
        if (headerView == null && footerView == null){
            return TYPE_NORMAL;
        }
        if (position == 0){
            return TYPE_HEADER;
        }
        if (position == getItemCount() -1){
            return TYPE_FOOTER;
        }
        return TYPE_NORMAL;
    }

    @Override
    public int getItemCount() {
        if(headerView == null && footerView == null){
            return stories.size();
        }else if (headerView == null && footerView != null){
            return stories.size()+1;
        }else if (headerView != null&& footerView == null){
            return stories.size()+1;
        }else {
            return stories.size()+2;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (headerView != null && viewType == TYPE_HEADER){
            return new Holder(headerView);
        }
        if (footerView != null && viewType == TYPE_FOOTER){
            return new Holder(footerView);
        }
        View view = LayoutInflater.from(context).inflate(R.layout.item_recyclerview,parent,false);
        view.setOnClickListener(this);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_NORMAL){
            if (holder instanceof Holder){
                final NewMessage.StoriesBean data = stories.get(position-1);
                ((Holder)holder).title.setText(data.getTitle());
                Glide.with(context)
                        .load(data.getImages().get(0))
                        .into(((Holder) holder).titleimage);
                holder.itemView.setTag(data);
            }
            return;
        }else if (getItemViewType(position) == TYPE_HEADER){
            return;
        }else {
            return;
        }
    }
    public class Holder extends RecyclerView.ViewHolder{
        private TextView title;
        private ImageView titleimage;
        public Holder(View view){
            super(view);
            if (view == headerView){
                return;
            }
            if (view == footerView){
                return;
            }
            title = (TextView)view.findViewById(R.id.item_title);
            titleimage = (ImageView)view.findViewById(R.id.item_title_image);
        }
    }
}
