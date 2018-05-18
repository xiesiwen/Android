package com.example.xiejingwen.m2.view;

import android.support.design.widget.CoordinatorLayout;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by xiejingwen on 2018/3/13.
 */

public class MyBehiver extends CoordinatorLayout.Behavior<TextView>{

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, TextView child, View dependency) {
        return dependency instanceof DependencyView;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, TextView child, View dependency) {
        int bottom = dependency.getBottom();
        Log.e("xsw", "text h is " + child.getHeight());
        child.layout(child.getLeft(), bottom + 10, child.getRight() , bottom + 10 + child.getHeight());
        return true;
    }
}
