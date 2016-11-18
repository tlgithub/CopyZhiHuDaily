package com.example.zhihudaily;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.zhihudaily.Bean.NewMessage;
import com.example.zhihudaily.Bean.StoryBean;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 教科书式的机智少年 on 2016/11/11.
 */

public class TopStroryActivity extends AppCompatActivity {
    //private NewMessage.StoriesBean sb;
    private NewMessage.TopStoriesBean tsb;
    private StoryBean storyBean;
    private String str;
    private Context context;
    private ImageView topImage;
    private WebView content;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stories);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        topImage = (ImageView)findViewById(R.id.stories_headImage);
        content = (WebView)findViewById(R.id.story_web);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        context = this;
        Intent intent = this.getIntent();
        tsb = (NewMessage.TopStoriesBean) intent.getSerializableExtra("data");

        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 1) {
                    toolbar.setTitle(storyBean.getTitle());
                    Glide.with(context)
                            .load(storyBean.getImage())
                            .into(topImage);
                    content.loadDataWithBaseURL("file:///android_asset/style.css",storyBean.getBody(),"text/html","UTF-8",null);
                }
            }
        };

        new Thread() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url("http://news-at.zhihu.com/api/4/news/" + tsb.getId())
                        .get()
                        .build();
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        str = response.body().string();
                        Log.e("data", str);
                        Gson gson = new Gson();
                        storyBean = gson.fromJson(str, StoryBean.class);
                        Log.e("data",storyBean.getTitle());
                        Message msg = new Message();
                        msg.what = 1;
                        handler.sendMessage(msg);
                    }
                });
            }
        }.start();
    }
}
