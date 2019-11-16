package com.example.androidstack;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.androidstack.internet_feature.ConnectionConstant;
import com.example.androidstack.internet_feature.OkHttpCallback;
import com.example.androidstack.internet_feature.OkHttpClientManager;
import com.example.androidstack.ui_layout.UILayoutCenter;
import com.example.androidstack.ui_view.UIViewActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button mBtnGoToUICenter, mBtnGoToViewCenter, mBtnHttpDownLoad, mBtnSearch;
    private TextView mTvHttpConnection;
    private EditText mEtHttpSearch;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        initView();
        initListener();
    }

    private void initView() {
        mBtnGoToUICenter = findViewById(R.id.ui_layout_center);
        mBtnGoToViewCenter = findViewById(R.id.ui_view_center);
        mBtnHttpDownLoad = findViewById(R.id.http_connection);
        mTvHttpConnection = findViewById(R.id.tv_http_connection);
        mEtHttpSearch = findViewById(R.id.edit_text_category);
        mBtnSearch = findViewById(R.id.http_connection_search);
    }

    private void initListener() {
        mBtnGoToUICenter.setOnClickListener(this);
        mBtnGoToViewCenter.setOnClickListener(this);
        mBtnHttpDownLoad.setOnClickListener(this);
        mBtnSearch.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ui_layout_center:
                startActivity(new Intent(this, UILayoutCenter.class));
                break;
            case R.id.ui_view_center:
                startActivity(new Intent(this, UIViewActivity.class));
                break;
            case R.id.http_connection:
                get();
                break;
            case R.id.http_connection_search:
                Map<String, String> mParamsMap = new HashMap<>();
                mParamsMap.put("q","明星");
                mParamsMap.put("sn","1");
                mParamsMap.put("pn","10");
                OkHttpClientManager.getInstance().getAsyn(this, ConnectionConstant.END_POINT, mParamsMap, new OkHttpCallback() {
                    @Override
                    public void onError(String msg) {

                    }

                    @Override
                    public void onResponse(final ArrayList<String> result) {
//                        MainActivity.this.runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                String s = null;
//                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                                    s = String.join(",",result);
//                                }
//                                mTvHttpConnection.setText(s);
//                                Log.d("HttpURL", s);
//                            }
//                        });
                    }
                });
                break;
//                MainActivity.this.runOnUiThread(new Runnable() {
//                    @RequiresApi(api = Build.VERSION_CODES.O)
//                    @Override
//                    public void run() {
//                        String s = null;
//                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                            s = String.join(",", mHelper.strings.toArray(new String[mHelper.strings.size()]));
//                        }
//                        mTvHttpConnection.setText(s);
//                    }
//                });
            default:
                break;
        }
    }

    public void get() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().
                connectTimeout(15, TimeUnit.SECONDS).
                readTimeout(20, TimeUnit.SECONDS).
                writeTimeout(20, TimeUnit.SECONDS).
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
                final String htmlStr = response.body().string();
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mTvHttpConnection.setText(htmlStr);
                    }
                }, 0);

//                MainActivity.this.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//
//                        mTvHttpConnection.setText(htmlStr);
//                    }
//                });
            }
        });
    }

//    public void httpConnection(View view) {
//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                MainActivity.this.get();
//                mBtnHttpDownLoad.setText(htmlStr);
//                mTvHttpConnection.setText(htmlStr);
//            }
//        },0);
//
//    }


    /**
     * Handler
     */


}
