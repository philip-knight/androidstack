package com.example.androidstack.ui_layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.androidstack.R;

public class UILayoutCenter extends AppCompatActivity implements View.OnClickListener{
    private Button mBtnGoToLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uilayout_center);
        init();
    }

    private void init(){
        initView();
        initListener();
    }

    private void initView(){
        mBtnGoToLinearLayout = findViewById(R.id.ui_layout_linearlayout);
    }

    private void initListener(){
        mBtnGoToLinearLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ui_layout_linearlayout:
                startActivity(new Intent(this, LinearLayoutActivity.class));
                break;
            default:
                break;
        }
    }
}
