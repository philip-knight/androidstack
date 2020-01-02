package com.example.androidstack.internet_feature;

import java.io.IOException;

import okhttp3.Response;

/**
 * Created by Philip.Knight.
 * User Email: 411735025@qq.com
 * Date: 2019-11-09
 * Time: 11:22
 * Desc:
 * Version:
 */
public interface OkHttpCallback {
    void onError(String msg);
    void onResponse(Response response) throws IOException;
}
