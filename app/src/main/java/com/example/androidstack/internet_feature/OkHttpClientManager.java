package com.example.androidstack.internet_feature;

import android.app.Activity;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
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
    private OkHttpConnectionBean okHttpConnectionBean;
    private Gson gson;

    public OkHttpClientManager() {
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
                public void onResponse(Call call, final Response response) throws IOException {
                    if (response.isSuccessful()) {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
//                                    callback.onResponse(response.body().string());
                                    gson = new Gson();
                                    okHttpConnectionBean = gson.fromJson(response.body().string(), OkHttpConnectionBean.class);
                                    callback.onResponse(parseJsonWithGson2(okHttpConnectionBean));
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                }
            });
        } catch (Exception e) {
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

    private static ArrayList<String> parseJsonWithGson2(OkHttpConnectionBean okHttpConnectionBean) {
        ArrayList<String> mImgLink = new ArrayList<>();
        for (int i = 0; i < okHttpConnectionBean.getList().size(); i++) {
            mImgLink.add(i, okHttpConnectionBean.getList().get(i).getImg());
        }
        return mImgLink;
    }


    private JSONObject connection = new JSONObject();
    public ArrayList<String> strings = new ArrayList<>();

    public void createHttpRequest(String url) {

        OkHttpClient client = new OkHttpClient();

        Request.Builder builder = new Request.Builder();

        Request request = builder.get().url(url).build();

        Call call = client.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //
                final String htmlStr = response.body().string();
                connection = responseToJSON(htmlStr);
                strings = parseJsonWithGson2(getConnectionResult(connection));
            }
        });
    }

    public JSONObject responseToJSON(String string) {
        JSONObject result = null;
        try {
            result = new JSONObject(string);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }

    public JSONObject getConnection() {
        return connection;
    }

    public void setConnection(JSONObject connection) {
        this.connection = connection;
    }


    public static OkHttpConnectionBean getConnectionResult(JSONObject connection) {
        Gson gson = new Gson();
        OkHttpConnectionBean okHttpConnectionBean = gson.fromJson(String.valueOf(connection), OkHttpConnectionBean.class);
        return okHttpConnectionBean;
    }
}
