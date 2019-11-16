package com.example.androidstack.ui_view.recyclerview_origin;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.androidstack.R;
import com.example.androidstack.internet_feature.ConnectionConstant;
import com.example.androidstack.internet_feature.OkHttpCallback;
import com.example.androidstack.internet_feature.OkHttpClientManager;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mRecyclerViewAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<String> mData = new ArrayList<>();
//    private Handler mHandler = new Handler();
    //    HttpManager mManager = new HttpManager();
    OkHttpClientManager mHelper = new OkHttpClientManager();
    private RefreshLayout mRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        initView();
        new Thread(new Runnable() {
            @Override
            public void run() {
                Map<String, String> mParamsMap = new HashMap<>();
                mParamsMap.put("q", "动画");
                mParamsMap.put("sn", "7");
                mParamsMap.put("pn", "20");
                OkHttpClientManager.getInstance().getAsyn(RecyclerViewActivity.this, ConnectionConstant.END_POINT, mParamsMap, new OkHttpCallback() {
                    @Override
                    public void onError(String msg) {

                    }

                    @Override
                    public void onResponse(final ArrayList<String> result) {
                        String s = null;
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            s = String.join(",", result);
                            Log.d("HttpURL", s);
                        }

                        RecyclerViewActivity.this.mData = result;
                        mRecyclerViewAdapter.setmData(result);
                        RecyclerViewActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mRecyclerViewAdapter.notifyDataSetChanged();
                                mRecyclerView.invalidate();
                            }
                        });
                    }
                });
            }
        }).start();


//        initData();
//        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        mLayoutManager = new GridLayoutManager(this,3);
        mLayoutManager = new StaggeredGridLayoutManager(3, OrientationHelper.VERTICAL);

        mRecyclerViewAdapter = new RecyclerViewAdapter(this, mData);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.recycler_view);
        mRefreshLayout = findViewById(R.id.refresh_layout);
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Thread.currentThread().setName("work thread");
                        String  s = Integer.toString((int) Math.random()*10);
                        Map<String, String> mParamsMap = new HashMap<>();

                        mParamsMap.put("q", "娱乐");
                        mParamsMap.put("sn", s);
                        mParamsMap.put("pn", "20");
                        OkHttpClientManager.getInstance().getAsyn(RecyclerViewActivity.this, ConnectionConstant.END_POINT, mParamsMap, new OkHttpCallback() {
                            @Override
                            public void onError(String msg) {

                            }

                            @Override
                            public void onResponse(final ArrayList<String> result) {
                                String s = null;
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                    s = String.join(",", result);
                                    Log.d("HttpURL", s);
                                }

                                RecyclerViewActivity.this.mData = result;
                                mRecyclerViewAdapter.setmData(result);
                                RecyclerViewActivity.this.runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        mRecyclerViewAdapter.notifyDataSetChanged();
                                        mRecyclerView.invalidate();
                                    }
                                });
                            }
                        });

//                List<String> data = initDatas();

                        Message message = new Message();
                        message.what = 1 ;
//                message.obj = data ;
                        mHandler.sendMessageDelayed(message,2000);
                    }
                }).start();

            }
        });


        mRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshLayout) {


                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String  s = Integer.toString((int) Math.random()*10);
                        Map<String, String> mParamsMap = new HashMap<>();

                        mParamsMap.put("q", "动画");
                        mParamsMap.put("sn", s);
                        mParamsMap.put("pn", "20");
                        OkHttpClientManager.getInstance().getAsyn(RecyclerViewActivity.this, ConnectionConstant.END_POINT, mParamsMap, new OkHttpCallback() {
                            @Override
                            public void onError(String msg) {

                            }

                            @Override
                            public void onResponse(final ArrayList<String> result) {
                                String s = null;
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                    s = String.join(",", result);
                                    Log.d("HttpURL", s);
                                }

                                RecyclerViewActivity.this.mData = result;
                                mRecyclerViewAdapter.setmData(result);
                                RecyclerViewActivity.this.runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        mRecyclerViewAdapter.notifyDataSetChanged();
                                        mRecyclerView.invalidate();
                                    }
                                });
                            }
                        });
//                List<String>  data = initDatas();

                        Message message = new Message();
                        message.what = 2;
//                message.obj = data ;
                        mHandler.sendMessageDelayed(message,2000);
                    }
                }).start();
            }
        });
    }

    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what){
                case 1:         //刷新加载
                    List<String> mList  = (List<String>) msg.obj;
                    mRefreshLayout.finishRefresh(true);
//                        adapter.setDatas(mList);
                    break;
                case 2:         //加载更多
                    List<String> mLoadMoreDatas = (List<String>) msg.obj;
                    mRefreshLayout.finishLoadMore(true);
//                        adapter.addMoreValue(mLoadMoreDatas);
                    break;
            }
            return false;
        }
    });

    private void initData() {
//        mData = new ArrayList<>();
//        for (int i = 0; i < 10; i++){
//            mData.add(R.drawable.recommended_hd_20);
//        }
//        mData = mHelper.strings;
    }


}
