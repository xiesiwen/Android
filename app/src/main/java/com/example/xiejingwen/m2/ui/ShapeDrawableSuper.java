package com.example.xiejingwen.m2.ui;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.Shape;

/**
 * Created by xiejingwen on 2017/11/17.
 */

public class ShapeDrawableSuper extends ShapeDrawable {
    @Override
    protected void onDraw(Shape shape, Canvas canvas, Paint paint) {
        super.onDraw(shape, canvas, paint);
    }
}
