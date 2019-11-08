package com.example.androidstack.ui_view.recyclerview_origin;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidstack.R;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mRecyclerViewAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Integer> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        initView();
        initData();
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
//        mLayoutManager = new StaggeredGridLayoutManager(2, OrientationHelper.VERTICAL);
        mRecyclerViewAdapter = new RecyclerViewAdapter(this,mData);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.recycler_view);
    }

    private void initData() {
        mData = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            mData.add(R.drawable.recommended_hd_20);
        }
    }


}
