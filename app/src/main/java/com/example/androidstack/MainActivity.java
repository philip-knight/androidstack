package com.example.androidstack;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.androidstack.ui_layout.UILayoutCenter;
import com.example.androidstack.ui_view.UIViewActivity;

public class MainActivity extends Activity implements View.OnClickListener{

    private Button mBtnGoToUICenter, mBtnGoToViewCenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        initView();
        initListener();
    }

    private void initView(){
        mBtnGoToUICenter = findViewById(R.id.ui_layout_center);
        mBtnGoToViewCenter = findViewById(R.id.ui_view_center);
    }

    private void initListener(){
        mBtnGoToUICenter.setOnClickListener(this);
        mBtnGoToViewCenter.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ui_layout_center:
                startActivity(new Intent(this, UILayoutCenter.class));
                break;
            case R.id.ui_view_center:
                startActivity(new Intent(this, UIViewActivity.class));
                break;
            default:
                break;
        }
    }
}
