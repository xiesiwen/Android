package com.example.xiejingwen.m2.dialog;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by xiejingwen on 2017/11/8.
 */

public class ClipLinearLayout extends LinearLayout {
    Paint paint;
    public ClipLinearLayout(Context context) {
        this(context, null);
    }
    
    public ClipLinearLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    
    public ClipLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.YELLOW);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    @Override
    public void draw(Canvas canvas) {
        int saveCount = canvas.getSaveCount();
        final int flags = Canvas.ALL_SAVE_FLAG;
        canvas.saveLayer(0, 0, getWidth(), getHeight(), null, flags);
        super.draw(canvas);
        canvas.drawBitmap(makeSrc(getWidth(), getHeight()),0,0, paint);
        canvas.restoreToCount(saveCount);
    }

    static Bitmap makeSrc(int w, int h) {
        Bitmap bm = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bm);
        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);

        p.setColor(0xFF66AAFF);
        c.drawRoundRect(0, 0, w, h, 80 ,80, p);
        return bm;
    }
}
