package com.example.zhihudaily.InterFace;

import android.view.View;

import com.example.zhihudaily.Bean.NewMessage;

/**
 * Created by 教科书式的机智少年 on 2016/11/6.
 */

public interface onMainRecyclerViewItemClickListner {
    void onItemClick(View view, NewMessage.StoriesBean data);
}
