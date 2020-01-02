package com.example.androidstack.internet_feature;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Philip.Knight.
 * User Email: 411735025@qq.com
 * Date: 2019-11-08
 * Time: 20:07
 * Desc:
 * Version:
 */
public class OkHttpClientManager {
    private static OkHttpClientManager instance;
    private OkHttpClient OkHttpClient;
    private OkHttpCallback callback;
    private String url;
    private Map<String, String> requestParams = new HashMap<>();
    private Context context;

    private OkHttpClientManager() {
        OkHttpClient = new OkHttpClient.Builder().
                connectTimeout(15, TimeUnit.SECONDS).
                readTimeout(20, TimeUnit.SECONDS).
                writeTimeout(20, TimeUnit.SECONDS).
                retryOnConnectionFailure(true).
                build();
    }

    public static OkHttpClientManager getInstance() {
        if (instance == null) {
            synchronized (OkHttpClientManager.class) {
                if (instance == null) {
                    instance = new OkHttpClientManager();
                }
            }
        }
        return instance;
    }


    public void getAsyn(final Activity activity, String url, Map<String, String> requestParams, final OkHttpCallback callback) {
        try {
            final Request request = new Request.Builder()
                    .get()
                    .tag(activity.getClass().getSimpleName())
                    .url(onBuildGetParams(url, requestParams))
                    .build();
            Call call = OkHttpClient.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    callback.onError(String.valueOf(e));
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    if (response.isSuccessful()) {
                        callback.onResponse(response);
                    }
                }
            });
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private String onBuildGetParams(String url, Map<String, String> requestParams) {
        StringBuffer sb = new StringBuffer(url);
        boolean isFirstParam = true;
        if (requestParams == null) {
            return sb.toString();
        }

        for (Map.Entry<String, String> entry : requestParams.entrySet()) {
            if (isFirstParam) {
                isFirstParam = false;
                sb.append("?" + entry.getKey() + "=" + entry.getValue());
            } else {
                sb.append("&" + entry.getKey() + "=" + entry.getValue());
            }

            Log.d("HttpURL", sb.toString());
        }
        return sb.toString();
    }
}
