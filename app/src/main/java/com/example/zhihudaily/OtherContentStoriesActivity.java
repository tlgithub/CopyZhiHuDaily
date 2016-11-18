package com.example.zhihudaily;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.zhihudaily.Bean.OtherContentBean;
import com.example.zhihudaily.Bean.StoryBean;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 教科书式的机智少年 on 2016/11/10.
 */

public class OtherContentStoriesActivity extends AppCompatActivity {
    private WebView content;
    private OtherContentBean.StoriesBean sb;
    private StoryBean storyBean;
    private Toolbar toolbar;
    private WebSettings settings;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stories);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        content = (WebView)findViewById(R.id.story_web);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent intent = this.getIntent();
        sb = (OtherContentBean.StoriesBean)intent.getSerializableExtra("data");

        settings = content.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);

        new Thread(){
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("http://news-at.zhihu.com/api/4/news/"+sb.getId())
                        .get()
                        .build();
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String str = response.body().string();
                        Gson gson = new Gson();
                        storyBean = gson.fromJson(str,StoryBean.class);
                        System.out.println(storyBean.getId());
                        Message msg = new Message();
                        msg.what = 1;
                        handler.sendMessage(msg);
                    }
                });
            }
        }.start();

    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    toolbar.setTitle(storyBean.getTitle());
                    content.loadDataWithBaseURL("style.css",storyBean.getBody(),"text/html","UTF-8",null);
                    break;
            }
        }
    };
}
