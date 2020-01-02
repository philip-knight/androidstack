package com.example.androidstack.ui_view.canvas;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class CanvasActivity extends AppCompatActivity {
    private CustomView mCustomview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new CustomView(this));
    }
}
