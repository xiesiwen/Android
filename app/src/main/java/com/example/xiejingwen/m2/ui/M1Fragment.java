package com.example.xiejingwen.m2.ui;

import com.example.xiejingwen.m2.R;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by xiejingwen on 2018/3/7.
 */

public class M1Fragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("xsw", "mf1 create view " + name);
        return inflater.inflate(R.layout.f2, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("xsw", "mf1 on resume " + name);
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("xsw", "mf1 on pause " + name);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("xsw", "mf1 on detach " + name);
    }

    public String name ="";
}
