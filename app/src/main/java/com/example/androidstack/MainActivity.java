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
import com.example.androidstack.ui_layout.UILayoutCenterActivity;
import com.example.androidstack.ui_view.UIViewCenterActivity;
import com.example.androidstack.ui_view.canvas.CanvasActivity;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Response;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button mBtnGoToUICenter, mBtnGoToViewCenter, mBtnHttpDownLoad, mBtnSearch, mBtnGotoCanvas;
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
        mBtnHttpDownLoad = findViewById(R.id.http_download_connection);
        mTvHttpConnection = findViewById(R.id.tv_http_connection);
        mEtHttpSearch = findViewById(R.id.edit_text_category);
        mBtnSearch = findViewById(R.id.http_connection_search);
        mBtnGotoCanvas = findViewById(R.id.canvas_activity);
    }

    private void initListener() {
        mBtnGoToUICenter.setOnClickListener(this);
        mBtnGoToViewCenter.setOnClickListener(this);
        mBtnHttpDownLoad.setOnClickListener(this);
        mBtnSearch.setOnClickListener(this);
        mBtnGotoCanvas.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ui_layout_center:
                startActivity(new Intent(this, UILayoutCenterActivity.class));
                break;
            case R.id.ui_view_center:
                startActivity(new Intent(this, UIViewCenterActivity.class));
                break;
            case R.id.http_download_connection:
                break;
            case R.id.http_connection_search:
                Map<String, String> mParamsMap = new HashMap<>();
                mParamsMap.put("q", "明星");
                mParamsMap.put("sn", "1");
                mParamsMap.put("pn", "10");
                OkHttpClientManager.getInstance().getAsyn(MainActivity.this, ConnectionConstant.END_POINT, mParamsMap, new OkHttpCallback() {
                    @Override
                    public void onError(String msg) {

                    }

                    @Override
                    public void onResponse(final Response response) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mTvHttpConnection.setText(response.toString());
                            }
                        });
                    }
                });
                break;
            case R.id.canvas_activity:
                startActivity(new Intent(this, CanvasActivity.class));
                break;
            default:
                break;
        }
    }
}
