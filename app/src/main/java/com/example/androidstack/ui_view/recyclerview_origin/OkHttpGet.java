package com.example.androidstack.ui_view.recyclerview_origin;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Philip.Knight.
 * User Email: 411735025@qq.com
 * Date: 2019-11-07
 * Time: 23:02
 * Desc:
 * Version:
 */
public class OkHttpGet {
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
                String htmlStr =  response.body().string();
            }
        });
    }
}
