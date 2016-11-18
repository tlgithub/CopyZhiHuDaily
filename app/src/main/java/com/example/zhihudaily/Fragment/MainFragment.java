package com.example.zhihudaily.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.zhihudaily.Adapter.MainAdapter;
import com.example.zhihudaily.Adapter.TopViewPagerAdapter;
import com.example.zhihudaily.Bean.NewMessage;
import com.example.zhihudaily.InterFace.onMainRecyclerViewItemClickListner;
import com.example.zhihudaily.R;
import com.example.zhihudaily.StoriesActivity;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.example.zhihudaily.MainActivity.tag;

/**
 * Created by 教科书式的机智少年 on 2016/11/8.
 */

public class MainFragment extends Fragment{
    private Context context;
    private List<NewMessage.StoriesBean> stories;
    private List<NewMessage.TopStoriesBean> topStories;
    private RecyclerView todaynews;
    private List<NewMessage.StoriesBean> thisStories;
    private SwipeRefreshLayout swipeRefresh;
    private LinearLayoutManager linearlayoutmanager;
    private MainAdapter mainAdapter;
    private int lastVisibleItem;
    private List<NewMessage.StoriesBean> moreStories;
    private ArrayList<View> topMessage;
    public View view;
    private ViewPager vp;
    private LinearLayout ll;
    private ArrayList<ImageView> dots;

    public Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                //创建界面
                case 1:
                    /*initview();
                    //topimage.setAdapter(new TopViewPagerAdapter(topImages));
                    linearlayoutmanager = new LinearLayoutManager(context);
                    todaynews.setLayoutManager(linearlayoutmanager);
                    adapter = new MainRecyclerViewAdapter(context,stories);
                    View view = LayoutInflater.from(context).inflate(R.layout.head_main,todaynews,false);
                    ViewPager viewpager = (ViewPager)view.findViewById(R.id.main_head);
                    viewpager.setAdapter(new TopViewPagerAdapter(context,topMessage,topStories));
                    adapter.setHeaderView(view);
                    adapter.setOnItemClickListener(new onMainRecyclerViewItemClickListner() {
                        @Override
                        public void onItemClick(View view, NewMessage.StoriesBean data) {
                            Intent intent = new Intent(context,StoriesActivity.class);
                            intent.putExtra("data",data);
                            startActivity(intent);
                        }
                    });
                    todaynews.setAdapter(adapter);
                    break;*/

                    initview();
                    linearlayoutmanager = new LinearLayoutManager(context);
                    todaynews.setLayoutManager(linearlayoutmanager);
                    mainAdapter = new MainAdapter(context,stories);
                    View view = LayoutInflater.from(context).inflate(R.layout.head_main,todaynews,false);
                    vp = (ViewPager)view.findViewById(R.id.main_head);
                    ll = (LinearLayout)view.findViewById(R.id.main_head_ll);
                    initDots();
                    vp.setAdapter(new TopViewPagerAdapter(context,topMessage,topStories,handler));
                    View footer = LayoutInflater.from(context).inflate(R.layout.footer_progress,todaynews,false);
                    mainAdapter.setHeaderView(view);
                    mainAdapter.setFooterView(footer);
                    mainAdapter.setOnItemClickListener(new onMainRecyclerViewItemClickListner() {
                        @Override
                        public void onItemClick(View view, NewMessage.StoriesBean data) {
                            Intent intent = new Intent(context,StoriesActivity.class);
                            intent.putExtra("data",data);
                            startActivity(intent);
                        }
                    });
                    todaynews.setAdapter(mainAdapter);
                    vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                        @Override
                        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                        }

                        @Override
                        public void onPageSelected(int position) {
                            for(int i = 0;i<dots.size();i++){
                                if (position%dots.size() == i){
                                    dots.get(i).setImageResource(R.drawable.enabletrue);
                                }else {
                                    dots.get(i).setImageResource(R.drawable.enablefalse);
                                }
                            }
                        }

                        @Override
                        public void onPageScrollStateChanged(int state) {

                        }
                    });
                    handler.sendEmptyMessageDelayed(4,3000);
                    break;
                //刷新界面
                case 2:
                    /*linearlayoutmanager = new LinearLayoutManager(context);
                    todaynews.setLayoutManager(linearlayoutmanager);
                    adapter = new MainRecyclerViewAdapter(context,thisStories);
                    View view1 = LayoutInflater.from(context).inflate(R.layout.head_main,todaynews,false);
                    ViewPager viewpager1 = (ViewPager)view1.findViewById(R.id.main_head);
                    viewpager1.setAdapter(new TopViewPagerAdapter(context,topMessage,topStories));
                    adapter.setHeaderView(view1);
                    adapter.setOnItemClickListener(new onMainRecyclerViewItemClickListner() {
                        @Override
                        public void onItemClick(View view, NewMessage.StoriesBean data) {
                            Intent intent = new Intent(context,StoriesActivity.class);
                            intent.putExtra("data",data);
                            startActivity(intent);
                        }
                    });
                    todaynews.setAdapter(adapter);
                    swipeRefresh.setRefreshing(false);
                    Toast.makeText(context, "刷新成功", Toast.LENGTH_SHORT).show();
                    break;*/

                    /*linearlayoutmanager = new LinearLayoutManager(context);
                    todaynews.setLayoutManager(linearlayoutmanager);
                    mainAdapter = new MainAdapter(context,thisStories);
                    View view1 = LayoutInflater.from(context).inflate(R.layout.head_main,todaynews,false);
                    vp = (ViewPager)view1.findViewById(R.id.main_head);
                    vp.setAdapter(new TopViewPagerAdapter(context,topMessage,topStories,handler));
                    View footer1 = LayoutInflater.from(context).inflate(R.layout.footer_progress,todaynews,false);
                    mainAdapter.setHeaderView(view1);
                    mainAdapter.setFooterView(footer1);
                    mainAdapter.setOnItemClickListener(new onMainRecyclerViewItemClickListner() {
                        @Override
                        public void onItemClick(View view, NewMessage.StoriesBean data) {
                            Intent intent = new Intent(context,StoriesActivity.class);
                            intent.putExtra("data",data);
                            startActivity(intent);
                        }
                    });*/
                    mainAdapter.upData(thisStories);
                    swipeRefresh.setRefreshing(false);
                    Toast.makeText(context, "刷新成功", Toast.LENGTH_SHORT).show();
                    break;
                //填充上拉加载内容
                case 3:
                    mainAdapter.addMore(moreStories);
                    break;
                case 4:
                    int currentItem = vp.getCurrentItem();
                    vp.setCurrentItem(++currentItem);
                    handler.sendEmptyMessageDelayed(4,2000);
            }
        }
    };


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_main,container,false);
        context = getContext();
        todaynews = (RecyclerView)view.findViewById(R.id.main_recycler_head);
        swipeRefresh = (SwipeRefreshLayout)view.findViewById(R.id.main_swipe);
        swipeRefresh.setColorSchemeResources(R.color.swipred);
        todaynews.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem+1 == mainAdapter.getItemCount()){
                    new Thread(){
                        @Override
                        public void run() {
                            OkHttpClient client = new OkHttpClient();
                            Request request = new Request.Builder()
                                    .url("http://news.at.zhihu.com/api/4/news/before/20161108")
                                    .get()
                                    .build();
                            client.newCall(request).enqueue(new Callback() {
                                @Override
                                public void onFailure(Call call, IOException e) {

                                }

                                @Override
                                public void onResponse(Call call, Response response) throws IOException {
                                    Gson gson = new Gson();
                                    NewMessage nm = gson.fromJson(response.body().string(),NewMessage.class);
                                    moreStories = nm.getStories();
                                    Log.e(tag,moreStories.get(0).getTitle());
                                    Message msg = new Message();
                                    msg.what = 3;
                                    handler.sendMessage(msg);
                                }
                            });

                        }
                    }.start();
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = linearlayoutmanager.findLastVisibleItemPosition();
            }
        });

        //加载数据
        new Thread(){
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("http://news-at.zhihu.com/api/4/news/latest")
                        .build();
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        Gson gson = new Gson();
                        NewMessage nm = gson.fromJson(response.body().string(),NewMessage.class);
                        stories = nm.getStories();
                        topStories = nm.getTop_stories();
                        Message msg = new Message();
                        msg.what = 1;
                        handler.sendMessage(msg);
                        Log.e(tag,nm.getDate());
                    }
                });
            }
        }.start();

        //设置下拉刷新事件
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                ArrayList<NewMessage.StoriesBean> newstories = new ArrayList<NewMessage.StoriesBean>();
                new Thread(){
                    @Override
                    public void run() {
                        OkHttpClient client = new OkHttpClient();
                        Request request = new Request.Builder()
                                .url("http://news-at.zhihu.com/api/4/news/latest")
                                .get()
                                .build();
                        client.newCall(request).enqueue(new Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {

                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                                Gson gson = new Gson();
                                NewMessage nm = gson.fromJson(response.body().string(),NewMessage.class);
                                thisStories = nm.getStories();
                                Message msg = new Message();
                                msg.what = 2;
                                handler.sendMessage(msg);
                            }
                        });
                    }
                }.start();
            }
        });

        return view;
    }



    void initview(){
        topMessage = new ArrayList<View>();
        for (int i = 0;i<topStories.size();i++){
            View view = LayoutInflater.from(context).inflate(R.layout.head_other,null);
            ImageView image = (ImageView)view.findViewById(R.id.other_head);
            TextView text = (TextView)view.findViewById(R.id.other_head_title);
            text.setText(topStories.get(i).getTitle());
            Glide.with(context)
                    .load(topStories.get(i).getImage())
                    .into(image);
            topMessage.add(view);
        }

    }
    void initDots(){
        dots = new ArrayList<ImageView>();
        for(int i = 0;i<topStories.size();i++){
            ImageView view = new ImageView(context);
            if(i == 0){
                view.setImageResource(R.drawable.enabletrue);
            }else {
                view.setImageResource(R.drawable.enablefalse);
            }
            //把小圆点添加进LinearLayout中
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(20,20);
            params.setMargins(5,0,5,0);
            ll.addView(view,params);
            dots.add(view);
        }
    }
}
