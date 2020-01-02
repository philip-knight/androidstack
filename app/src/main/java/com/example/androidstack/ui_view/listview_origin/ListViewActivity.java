package com.example.androidstack.ui_view.listview_origin;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidstack.R;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 从 arrays 里加载基本数据
        setContentView(R.layout.activity_list_view);
    }

    private void init(){
        initView();
    }

    private void initView(){
    }
}
