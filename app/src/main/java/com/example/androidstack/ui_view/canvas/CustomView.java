package com.example.androidstack.ui_view.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * Created by Philip.Knight.
 * User Email: 411735025@qq.com
 * Date: 2019-11-16
 * Time: 20:01
 * Desc:
 * Version:
 */
public class CustomView extends View {
    private Paint paint = new Paint();
    private int[] colors = {Color.parseColor("#fb5645"), Color.parseColor("#f2c225"), Color.parseColor("#3bb9e3"), Color.parseColor("#71ea6b")};
    private float viewWidth;
    private float viewHeight;

    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        paint.setColor(colors[1]);
        viewWidth = getWidth() >> 1;
        viewHeight = getHeight() >> 1;

        canvas.drawCircle(viewWidth, viewHeight, viewWidth / 4, paint);

        paint.setColor(colors[2]);
        Path path = new Path();
        path.moveTo(viewWidth, viewHeight);
        path.lineTo(viewWidth + viewWidth / 4, viewHeight + viewHeight / 4);
        path.lineTo(viewWidth + viewWidth / 4, viewHeight - viewHeight / 4);
        path.close();
        canvas.drawPath(path,paint);
    }
}
