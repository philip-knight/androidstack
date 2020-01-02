package com.example.androidstack.ui_view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidstack.R;
import com.example.androidstack.ui_view.listview_adapter.ListViewAdapterActivity;
import com.example.androidstack.ui_view.listview_base_adapter.ListViewBaseAdapterActivity;
import com.example.androidstack.ui_view.listview_origin.ListViewActivity;
import com.example.androidstack.ui_view.recyclerviewpro.RecyclerViewProActivity;
import com.example.androidstack.ui_view.test.CheckBoxGroupActivity;

public class UIViewCenterActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mGoToListViewEntry, mGoToListViewAdapter, mGoToBaseAdapterListView,
            mGoToRecyclerView, mGoToProRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uiview);
        init();
    }

    private void init() {
        initView();
        initListener();
    }

    private void initView() {
        mGoToListViewEntry = findViewById(R.id.ui_layout_list_view);
        mGoToListViewAdapter = findViewById(R.id.ui_layout_list_view_adapter);
        mGoToBaseAdapterListView = findViewById(R.id.ui_layout_list_view_base_adapter);
        mGoToRecyclerView = findViewById(R.id.ui_layout_recycler_view);
        mGoToBaseAdapterListView = findViewById(R.id.ui_layout_pro_recycler_view);
    }

    private void initListener() {
        mGoToListViewEntry.setOnClickListener(this);
        mGoToListViewAdapter.setOnClickListener(this);
        mGoToBaseAdapterListView.setOnClickListener(this);
        mGoToRecyclerView.setOnClickListener(this);
        mGoToBaseAdapterListView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ui_layout_list_view:
                startActivity(new Intent(this, ListViewActivity.class));
                break;
            case R.id.ui_layout_list_view_adapter:
                startActivity(new Intent(this, ListViewAdapterActivity.class));
                break;
            case R.id.ui_layout_list_view_base_adapter:
                startActivity(new Intent(this, ListViewBaseAdapterActivity.class));
                break;
            case R.id.ui_layout_recycler_view:
                startActivity(new Intent(this, CheckBoxGroupActivity.class));
                break;
            case R.id.ui_layout_pro_recycler_view:
                startActivity(new Intent(this, RecyclerViewProActivity.class));
                break;
            default:
                break;
        }
    }

    public int Sum_Solution(int n) {
        int sum = (int)(Math.pow(n,2)+n);
        return sum>>1;
    }
}
