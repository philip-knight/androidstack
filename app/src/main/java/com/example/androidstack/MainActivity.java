package com.example.androidstack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.androidstack.ui_layout.UILayoutCenter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mBtnGoToUICenter;

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
    }

    private void initListener(){
        mBtnGoToUICenter.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ui_layout_center:
                startActivity(new Intent(this, UILayoutCenter.class));
                break;
            default:
                break;
        }
    }
}
