package com.example.androidstack;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.androidstack.ui_layout.UILayoutCenter;
import com.example.androidstack.ui_view.UIViewActivity;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends Activity implements View.OnClickListener{

    private Button mBtnGoToUICenter, mBtnGoToViewCenter,mBtnHttpDownLoad;
    private TextView mTvHttpConnection;
    private static String htmlStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        initView();
        initListener();
    }

    private void initView(){
        mBtnGoToUICenter = findViewById(R.id.ui_layout_center);
        mBtnGoToViewCenter = findViewById(R.id.ui_view_center);
        mBtnHttpDownLoad = findViewById(R.id.http_connection);
        mTvHttpConnection = findViewById(R.id.tv_http_connection);

    }

    private void initListener(){
        mBtnGoToUICenter.setOnClickListener(this);
        mBtnGoToViewCenter.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ui_layout_center:
                startActivity(new Intent(this, UILayoutCenter.class));
                break;
            case R.id.ui_view_center:
                startActivity(new Intent(this, UIViewActivity.class));
                break;
            default:
                break;
        }
    }

    public void get(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder().
                connectTimeout(15, TimeUnit.SECONDS).
                readTimeout(20,TimeUnit.SECONDS).
                writeTimeout(20,TimeUnit.SECONDS).
                retryOnConnectionFailure(true).
                build();

        Request.Builder builder = new Request.Builder();

        Request request = builder.get().url("http://www.baidu.com/").build();

        Call call = okHttpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //
                MainActivity.htmlStr =  response.body().string();
            }
        });
    }

    public void httpConnection(View view) {
        get();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mBtnHttpDownLoad.setText(htmlStr);
                mTvHttpConnection.setText(htmlStr);
            }
        },0);

    }
}
