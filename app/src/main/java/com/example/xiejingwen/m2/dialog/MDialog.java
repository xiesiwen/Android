package com.example.xiejingwen.m2.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.example.xiejingwen.m2.R;

/**
 * Created by xiejingwen on 2017/12/1.
 */

public class MDialog extends Dialog{
    private FrameLayout mContentView;
    public MDialog(Context context) {
        this(context, 0);
    }

    public MDialog(Context context, int themeResId) {
        super(context, themeResId);
        initView(context);
    }

    protected MDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    private void initView(Context context){
        mContentView = (FrameLayout) View.inflate(context, R.layout.dialog_content, null);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}
