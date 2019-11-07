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
import com.example.androidstack.ui_view.recyclerview_origin.RecyclerViewActivity;
import com.example.androidstack.ui_view.test.MainActivity2;

public class UIViewActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mGoToListView, mGoToListViewAdapter, mGoToBaseAdapterListView, mGoToRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uiview);
        init();
    }

    private void init(){
        initView();
        initListener();
    }

    private void initView(){
        mGoToListView = findViewById(R.id.ui_layout_listview);
        mGoToListViewAdapter = findViewById(R.id.ui_layout_listview_adapter);
        mGoToRecyclerView = findViewById(R.id.ui_layout_recyclerview);
        mGoToBaseAdapterListView = findViewById(R.id.ui_layout_listview_base_adapter);
    }

    private void initListener(){
        mGoToListView.setOnClickListener(this);
        mGoToListViewAdapter.setOnClickListener(this);
        mGoToRecyclerView.setOnClickListener(this);
        mGoToBaseAdapterListView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.ui_layout_listview:
                startActivity(new Intent(this, ListViewActivity.class));
                break;
            case R.id.ui_layout_listview_adapter:
                startActivity(new Intent(this, ListViewAdapterActivity.class));
                break;
            case R.id.ui_layout_listview_base_adapter:
                startActivity(new Intent(this, ListViewBaseAdapterActivity.class));
                break;
            case R.id.ui_layout_recyclerview:
                startActivity(new Intent(this, MainActivity2.class));
                break;
            default:
                break;
        }
    }

    public void recyclerViewClick(View v){
        startActivity(new Intent(this, RecyclerViewActivity.class));
    }
}
