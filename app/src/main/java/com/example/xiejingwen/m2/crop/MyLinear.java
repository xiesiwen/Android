package com.example.xiejingwen.m2.crop;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by xiejingwen on 2017/11/8.
 */

public class MyLinear extends LinearLayout{
    public MyLinear(Context context) {
        super(context);
    }

    public MyLinear(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyLinear(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {

        super.dispatchDraw(canvas);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.RED);
        int sc = canvas.saveLayer(0, 0, getWidth(), getHeight(), paint,
                Canvas.ALL_SAVE_FLAG);
        Path path = new Path();
        path.addRoundRect(new RectF(10, 10, getWidth() - 10, getHeight() - 10), 80, 80,
                Path.Direction.CCW);
        canvas.drawPath(path, paint);

        paint.setColor(Color.GREEN);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));

        canvas.drawRect(new Rect(0, 0, getWidth(), getHeight()), paint);

        paint.setXfermode(null);
        canvas.restoreToCount(sc);
    }
}
