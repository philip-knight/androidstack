package com.example.androidstack.internet_feature;

import java.util.ArrayList;

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
    void onResponse(ArrayList<String> result);
}
