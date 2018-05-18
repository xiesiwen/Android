package com.example.xiejingwen.m2.ui;

import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.xiejingwen.m2.R;

/**
 * Created by xiejingwen on 2018/3/7.
 */

public class MFragment extends DialogFragment{

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().getWindow().setBackgroundDrawable(getResources().getDrawable(R.drawable.mb));
        return inflater.inflate(R.layout.f1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        TFra fra = new TFra();
        fragmentTransaction.add(R.id.zz, fra);
        fragmentTransaction.commit();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("xsw", "mf on resume");
    }
}
