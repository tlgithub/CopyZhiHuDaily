package com.example.zhihudaily.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zhihudaily.Adapter.OtherContentRecyclerViewAdatper;
import com.example.zhihudaily.Bean.OtherContentBean;
import com.example.zhihudaily.InterFace.onOtherRecyclerViewItemClickListner;
import com.example.zhihudaily.OtherContentStoriesActivity;
import com.example.zhihudaily.R;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 教科书式的机智少年 on 2016/11/10.
 */

public class OtherContentFragment extends Fragment{
    private Context context;
    private String id;
    private List<OtherContentBean.StoriesBean> sb;
    private OtherContentRecyclerViewAdatper adatper;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerView recyclerView;
    private OtherContentBean ocb;
    private int lastVisibleItem;
    private SwipeRefreshLayout swipeRefresh;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getContext();
        Bundle bundle = getArguments();
        id = bundle.getString("ID");
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_othercontent,container,false);
        swipeRefresh = (SwipeRefreshLayout)view.findViewById(R.id.other_swip);
        swipeRefresh.setColorSchemeResources(R.color.swipred);
        recyclerView = (RecyclerView)view.findViewById(R.id.other_recyclerview);

        new Thread(){
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("http://news-at.zhihu.com/api/4/theme/"+id)
                        .get()
                        .build();
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        Gson gson = new Gson();
                        ocb = gson.fromJson(response.body().string(), OtherContentBean.class);
                        sb = ocb.getStories();
                        Message msg = new Message();
                        msg.what = 1;
                        handler.sendMessage(msg);
                    }
                });
            }
        }.start();

        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Thread(){
                    @Override
                    public void run() {
                        OkHttpClient client = new OkHttpClient();
                        Request request = new Request.Builder()
                                .url("http://news-at.zhihu.com/api/4/theme/"+id)
                                .get()
                                .build();
                        client.newCall(request).enqueue(new Callback() {
                            @Override
                            public void onFailure(Call call, IOException e) {

                            }

                            @Override
                            public void onResponse(Call call, Response response) throws IOException {
                                Gson gson = new Gson();
                                ocb = gson.fromJson(response.body().string(), OtherContentBean.class);
                                sb = ocb.getStories();
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

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    linearLayoutManager = new LinearLayoutManager(context);
                    adatper = new OtherContentRecyclerViewAdatper(sb,context);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());
                    //adatper.setHeaderView(view);
                    recyclerView.setAdapter(adatper);
                    View view = LayoutInflater.from(context).inflate(R.layout.head_other,recyclerView,false);
                    ImageView image = (ImageView)view.findViewById(R.id.other_head);
                    TextView text = (TextView)view.findViewById(R.id.other_head_title);
                    text.setText(ocb.getDescription());
                    Glide.with(context)
                            .load(ocb.getImage())
                            .into(image);
                    adatper.setHeaderView(view);
                    adatper.setOnItemClickListner(new onOtherRecyclerViewItemClickListner() {
                        @Override
                        public void onItemClick(View view, OtherContentBean.StoriesBean data) {
                            Intent intent = new Intent(context, OtherContentStoriesActivity.class);
                            intent.putExtra("data",data);
                            startActivity(intent);
                        }
                    });
                    break;
                case 2:
                    linearLayoutManager = new LinearLayoutManager(context);
                    adatper = new OtherContentRecyclerViewAdatper(sb,context);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    View view1 = LayoutInflater.from(context).inflate(R.layout.head_other,recyclerView,false);
                    ImageView image1 = (ImageView)view1.findViewById(R.id.other_head);
                    TextView text1 = (TextView)view1.findViewById(R.id.other_head_title);
                    text1.setText(ocb.getDescription());
                    Glide.with(context)
                            .load(ocb.getImage())
                            .into(image1);
                    adatper.setHeaderView(view1);
                    adatper.setOnItemClickListner(new onOtherRecyclerViewItemClickListner() {
                        @Override
                        public void onItemClick(View view, OtherContentBean.StoriesBean data) {
                            Intent intent = new Intent(context, OtherContentStoriesActivity.class);
                            intent.putExtra("data",data);
                            startActivity(intent);
                        }
                    });
                    recyclerView.setAdapter(adatper);
                    swipeRefresh.setRefreshing(false);
            }
        }
    };

}
