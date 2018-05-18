package com.example.xiejingwen.m2;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by xiejingwen on 2017/11/3.
 */

public class ScaleImageView extends ImageView{
    public ScaleImageView(Context context) {
        super(context);
    }

    public ScaleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScaleImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMeasuredWidth();
        Drawable drawable = getDrawable();
        if (drawable instanceof BitmapDrawable) {
            int w = drawable.getIntrinsicWidth();
            int h = drawable.getIntrinsicHeight();
            int height = (int) (width * 1f / w * h);
            setMeasuredDimension(width, height);
        }
    }
}
