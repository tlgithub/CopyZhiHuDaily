package com.example.zhihudaily.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zhihudaily.Bean.OtherContentBean;
import com.example.zhihudaily.InterFace.onOtherRecyclerViewItemClickListner;
import com.example.zhihudaily.R;

import java.util.List;

/**
 * Created by 教科书式的机智少年 on 2016/11/10.
 */

public class OtherContentRecyclerViewAdatper extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener{
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_NORMAL = 1;
    private View headerView = null;
    private onOtherRecyclerViewItemClickListner onItemClickListner = null;
    private Context context;
    private List<OtherContentBean.StoriesBean> stories;

    private class Holder extends RecyclerView.ViewHolder{
        private TextView title;
        private ImageView titleimage;
        public Holder (View view){
            super(view);
            if (view == headerView){
                return;
            }
            title = (TextView)view.findViewById(R.id.item_title);
            titleimage = (ImageView)view.findViewById(R.id.item_title_image);
        }
    }

    public OtherContentRecyclerViewAdatper(List<OtherContentBean.StoriesBean> sb,Context context){
        this.stories = sb;
        this.context = context;
    }

    public void setHeaderView(View view){
        this.headerView = view;
        notifyItemInserted(0);
    }
    private View getHeaderView(){
        return headerView;
    }

    public void setOnItemClickListner(onOtherRecyclerViewItemClickListner clickListner){
        this.onItemClickListner = clickListner;
    }

    public int getRealPostion(RecyclerView.ViewHolder holder){
        int postion = holder.getLayoutPosition();
        return headerView == null?postion:postion-1;
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
    public void onClick(View v) {
        onItemClickListner.onItemClick(v,(OtherContentBean.StoriesBean)v.getTag());
    }

    @Override
    public int getItemCount() {
        return headerView == null?stories.size():stories.size()+1;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_HEADER){
            return;
        }
        final int pos = getRealPostion(holder);
        final OtherContentBean.StoriesBean data = stories.get(pos);
        if (holder instanceof Holder){
            ((Holder) holder).title.setText(data.getTitle());
            if (data.getImages().size()!=0&&data.getImages().get(0) != null){
                try {
                    Glide.with(context)
                            .load(data.getImages().get(0))
                            .into(((Holder)holder).titleimage);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }else {

            }
            ((Holder)holder).itemView.setTag(data);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (headerView != null && viewType == TYPE_HEADER){
            return new Holder(headerView);
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview,parent,false);
        view.setOnClickListener(this);
        return new Holder(view);
    }

    public void addMoreItem(List<OtherContentBean.StoriesBean> more){
        stories.addAll(more);
        notifyDataSetChanged();
    }
}
