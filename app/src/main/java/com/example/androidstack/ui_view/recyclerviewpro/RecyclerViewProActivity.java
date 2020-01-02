package com.example.androidstack.ui_view.recyclerviewpro;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.androidstack.R;
import com.example.androidstack.gsonparse.OkHttpConnectionBean;
import com.example.androidstack.internet_feature.ConnectionConstant;
import com.example.androidstack.internet_feature.OkHttpCallback;
import com.example.androidstack.internet_feature.OkHttpClientManager;
import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import okhttp3.Response;

public class RecyclerViewProActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RefreshLayout mRefreshLayout;
    private RecyclerViewProAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<String> mData = new ArrayList<>();
    private SmartRefreshLayout mSmartRefreshLayout;
    private String[] mCategory = {"体育","动物","旅游","娱乐","科技","汽车"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_pro);
        new Thread(new Runnable() {
            @Override
            public void run() {
                Map<String, String> mParamsMap = new HashMap<>();
                int pageIndex = getRandomNumber(20);
                int categoryIndex = getRandomNumber(5);
                final int countPerPage = 10;
                mParamsMap.put("q", mCategory[categoryIndex]);
                mParamsMap.put("sn", String.valueOf(pageIndex));
                mParamsMap.put("pn", String.valueOf(countPerPage));
                OkHttpClientManager.getInstance().getAsyn(RecyclerViewProActivity.this, ConnectionConstant.END_POINT, mParamsMap, new OkHttpCallback() {
                    @Override
                    public void onError(String msg) {
                        Toast.makeText(RecyclerViewProActivity.this,"返回错误",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onResponse(Response response) throws IOException {
                        Gson gson = new Gson();
                        OkHttpConnectionBean mOkHttpConnectionBean = gson.fromJson(response.body().string(),OkHttpConnectionBean.class);
                        parseJsonWithGson2(mOkHttpConnectionBean);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mAdapter.updateData(mData);
                            }
                        });
                    }
                });
            }
        }).start();
        initData();
        initView();
        initListener();
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(RecyclerViewProActivity.this,"启动成功",Toast.LENGTH_LONG).show();
    }

    private void initData(){
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        mAdapter = new RecyclerViewProAdapter(RecyclerViewProActivity.this, getData());
    }

    private void initView(){
        mRecyclerView = findViewById(R.id.recycler_view);
        mSmartRefreshLayout = findViewById(R.id.refresh_layout);
    }

    private void initListener(){
        mSmartRefreshLayout.setOnRefreshListener(new OnRefreshListener() { //下拉刷新
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Map<String, String> mParamsMap = new HashMap<>();
                        int pageIndex = getRandomNumber(20);
                        int categoryIndex = getRandomNumber(5);
                        final int countPerPage = 10;
                        mParamsMap.put("q", mCategory[categoryIndex]);
                        mParamsMap.put("sn", String.valueOf(pageIndex));
                        mParamsMap.put("pn", String.valueOf(countPerPage));
                        OkHttpClientManager.getInstance().getAsyn(RecyclerViewProActivity.this, ConnectionConstant.END_POINT, mParamsMap, new OkHttpCallback() {
                            @Override
                            public void onError(String msg) {
                                Toast.makeText(RecyclerViewProActivity.this,"返回错误",Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onResponse(Response response) throws IOException {
                                Gson gson = new Gson();
                                OkHttpConnectionBean mOkHttpConnectionBean = gson.fromJson(response.body().string(),OkHttpConnectionBean.class);
                                parseJsonWithGson2(mOkHttpConnectionBean);
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        mAdapter.updateData(mData);
                                    }
                                });
                            }
                        });
                    }
                }).start();
                refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
            }
        });

        mSmartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() { //上拉加载更多
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Map<String, String> mParamsMap = new HashMap<>();
                        int pageIndex = getRandomNumber(30);
                        int categoryIndex = getRandomNumber(5);
                        final int countPerPage = 10;
                        mParamsMap.put("q", mCategory[categoryIndex]);
                        mParamsMap.put("sn", String.valueOf(pageIndex));
                        mParamsMap.put("pn", String.valueOf(countPerPage));
                        OkHttpClientManager.getInstance().getAsyn(RecyclerViewProActivity.this, ConnectionConstant.END_POINT, mParamsMap, new OkHttpCallback() {
                            @Override
                            public void onError(String msg) {
                                Toast.makeText(RecyclerViewProActivity.this,"返回错误",Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onResponse(Response response) throws IOException {
                                Gson gson = new Gson();
                                OkHttpConnectionBean mOkHttpConnectionBean = gson.fromJson(response.body().string(),OkHttpConnectionBean.class);
                                parseJsonWithGson2(mOkHttpConnectionBean);
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        mAdapter.updateData(mData);
                                    }
                                });
                            }
                        });
                    }
                }).start();
                refreshlayout.finishLoadMore(2000);//传入false表示加载失败
            }
        });
    }

    private ArrayList<String> getData(){
        return mData;
    }

    private static Integer getRandomNumber(Integer max){
        Random rd = new Random();
        return rd.nextInt(max) + 1;
    }

    private void parseJsonWithGson2(OkHttpConnectionBean okHttpConnectionBean) {
        for (int i = 0; i < okHttpConnectionBean.getList().size(); i++) {
            mData.add(i, okHttpConnectionBean.getList().get(i).get_thumb());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.recycler_view, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @SuppressLint("WrongConstant")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.grid_layout:
                mLayoutManager = new GridLayoutManager(this, 4, OrientationHelper.VERTICAL, false);
                mRecyclerView.setLayoutManager(mLayoutManager);
                break;
            case R.id.staggered_grid:
                mLayoutManager = new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL);
                mRecyclerView.setLayoutManager(mLayoutManager);
                break;
            default:
                mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
                mRecyclerView.setLayoutManager(mLayoutManager);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
