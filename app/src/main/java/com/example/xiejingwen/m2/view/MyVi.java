package com.example.xiejingwen.m2.view;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.ListAdapter;

/**
 * Created by xiejingwen on 2017/11/30.
 */

public class MyVi extends WebView{
    public MyVi(Context context) {
        super(context);
    }

    public MyVi(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyVi(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public int computeVerticalScrollRange() {
        return super.computeVerticalScrollRange();
    }
}
