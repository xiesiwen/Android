package com.example.xiejingwen.m2.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewConfiguration;

/**
 * Created by xiejingwen on 2018/3/13.
 */

public class DependencyView extends android.support.v7.widget.AppCompatTextView {

    private final int mSlop;
    private float mLastX;
    private float mLastY;

    public DependencyView(Context context) {
        this(context,null);
    }

    public DependencyView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public DependencyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        setClickable(true);

        mSlop = ViewConfiguration.getTouchSlop();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
