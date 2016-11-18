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
 * Created by 教科书式的机智少年 on 2016/11/11.
 */

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener{

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_NORMAL = 1;
    private View headerView;
    private onMainRecyclerViewItemClickListner onItemClickListener = null;
    private Context context;
    private List<NewMessage.StoriesBean> stories;

    public class Holder extends RecyclerView.ViewHolder{
        private TextView title;
        private ImageView titleimage;
        public Holder(View view){
            super(view);
            title = (TextView)view.findViewById(R.id.item_title);
            titleimage = (ImageView)view.findViewById(R.id.item_title_image);
        }
    }

    public MainRecyclerViewAdapter(Context context, List<NewMessage.StoriesBean> stories){
        this.context = context;
        this.stories = stories;
    }

    public void setHeaderView(View view){
        this.headerView = view;
        notifyItemInserted(0);
    }
    private View getHeaderView(){
        return headerView;
    }

    public void setOnItemClickListener(onMainRecyclerViewItemClickListner onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    public int getRealPostion(RecyclerView.ViewHolder holder){
        int postion = holder.getLayoutPosition();
        return headerView == null?postion:postion-1;
    }

    @Override
    public void onClick(View v) {
        onItemClickListener.onItemClick(v,(NewMessage.StoriesBean)v.getTag());
    }

    @Override
    public int getItemViewType(int position) {
        if (headerView == null){
            return TYPE_NORMAL;
        }
        if (position == 0){
            return TYPE_HEADER;
        }
        return TYPE_NORMAL;
    }

    @Override
    public int getItemCount() {
        return headerView == null?stories.size():stories.size()+1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (headerView != null && viewType == TYPE_HEADER){
            return new Holder(headerView);
        }
        View view = LayoutInflater.from(context).inflate(R.layout.item_recyclerview,parent,false);
        view.setOnClickListener(this);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_HEADER){
            return;
        }
        final int pos = getRealPostion(holder);
        final NewMessage.StoriesBean data = stories.get(pos);
        if (holder instanceof Holder){
            ((Holder)holder).title.setText(data.getTitle());
            Glide.with(context)
                    .load(data.getImages().get(0))
                    .placeholder(R.mipmap.ic_launcher)
                    .into(((Holder) holder).titleimage);
            holder.itemView.setTag(data);
        }
    }

    public void addMoreItem(List<NewMessage.StoriesBean> more){
        stories.addAll(more);
        notifyDataSetChanged();
    }
}
