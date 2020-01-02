package com.example.androidstack.ui_layout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidstack.R;

public class UILayoutCenterActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mBtnGoToLinearLayout, mBtnGoToFrameLayout, mBtnGoToRelativeLayout,
    mBtnGoToGridLayout, mBtnGoToTableLayout;

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
        mBtnGoToFrameLayout = findViewById(R.id.ui_layout_framelayout);
        mBtnGoToRelativeLayout = findViewById(R.id.ui_layout_relativelayout);
        mBtnGoToGridLayout = findViewById(R.id.ui_layout_gridlayout);
        mBtnGoToTableLayout = findViewById(R.id.ui_layout_tablelayout);
    }

    private void initListener(){
        mBtnGoToLinearLayout.setOnClickListener(this);
        mBtnGoToFrameLayout.setOnClickListener(this);
        mBtnGoToRelativeLayout.setOnClickListener(this);
        mBtnGoToGridLayout.setOnClickListener(this);
        mBtnGoToTableLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ui_layout_linearlayout:
                startActivity(new Intent(this, LinearLayoutActivity.class));
                break;
            case R.id.ui_layout_framelayout:
                startActivity(new Intent(this, FrameLayoutActivity.class));
                break;
            case R.id.ui_layout_relativelayout:
                startActivity(new Intent(this, RelativeLayoutActivity.class));
                break;
            case R.id.ui_layout_gridlayout:
                startActivity(new Intent(this, GridActivity.class));
                break;
            case R.id.ui_layout_tablelayout:
                startActivity(new Intent(this, TableLayoutActivity.class));
                break;
            default:
                break;
        }
    }
}
