package com.example.zhihudaily.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.zhihudaily.Bean.NewMessage;
import com.example.zhihudaily.TopStroryActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 教科书式的机智少年 on 2016/11/5.
 */

public class TopViewPagerAdapter extends PagerAdapter {
    private ArrayList<View> views;
    private List<NewMessage.TopStoriesBean> tsb;
    private Context context;
    private Handler handler;

    public TopViewPagerAdapter(Context context,ArrayList<View> views, List<NewMessage.TopStoriesBean> topStoriesBeen,Handler handler){
        this.views = views;
        this.tsb = topStoriesBeen;
        this.context = context;
        this.handler = handler;
    }
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public int getCount() {
        //return images.size();
        //return views.size();
        return Integer.MAX_VALUE;
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        View view = views.get(position%views.size());
        /*view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("tag","onclidk");
                Intent intent = new Intent(context, TopStroryActivity.class);
                intent.putExtra("data",tsb.get(position%views.size()));
                context.startActivity(intent);
            }
        });*/

        view.setOnTouchListener(new View.OnTouchListener() {
            private long doweTime;
            private int downX;
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    //手指划走的事件
                    case MotionEvent.ACTION_CANCEL:
                        handler.sendEmptyMessageDelayed(4,3000);
                        break;
                    //手指按下的事件
                    case MotionEvent.ACTION_DOWN:
                        handler.removeCallbacksAndMessages(null);
                        Log.e("tag","手指压下了");
                        downX = (int)event.getX();
                        doweTime = System.currentTimeMillis();
                        break;
                    //手指抬起的事件
                    case MotionEvent.ACTION_UP:
                        if (System.currentTimeMillis()-doweTime<500
                                && Math.abs(downX-event.getX())<30){
                            Intent intent = new Intent(context, TopStroryActivity.class);
                            intent.putExtra("data",tsb.get(position%views.size()));
                            context.startActivity(intent);
                        }
                        handler.sendEmptyMessageDelayed(4,3000);
                        break;
                }
                return true;
            }
        });

        if (view.getParent() == null){
            container.addView(view);
        }else {
            ((ViewGroup)view.getParent()).removeView(view);
            container.addView(view);
        }
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //container.removeView(images.get(position));
        //container.removeView(views.get(position));
        container.removeView((View)object);
    }
}
