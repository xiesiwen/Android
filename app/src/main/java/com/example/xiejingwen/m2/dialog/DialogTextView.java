package com.example.xiejingwen.m2.dialog;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by xiejingwen on 2017/11/3.
 */

public class DialogTextView extends TextView {
    private float mScaleSize = 1f;
    
    public DialogTextView(Context context) {
        this(context, null);
    }
    
    public DialogTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    
    public DialogTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMeasuredWidth();
        Drawable drawable = getBackground();
        if (drawable instanceof BitmapDrawable || drawable instanceof NinePatchDrawable) {
            int w = drawable.getIntrinsicWidth();
            int h = drawable.getIntrinsicHeight();
            mScaleSize = width * 1f / w;
            int height = (int) (mScaleSize * h);
            setMeasuredDimension(width, height);
        }
    }
    
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.save();
        canvas.scale(mScaleSize, mScaleSize);
        super.onDraw(canvas);
        canvas.restore();
    }

    @Override
    public boolean showContextMenu() {
        return false;
    }
}
