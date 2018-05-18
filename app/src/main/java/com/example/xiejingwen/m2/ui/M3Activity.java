package com.example.xiejingwen.m2.ui;

import com.example.xiejingwen.m2.R;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by xiejingwen on 2018/5/17.
 */

public class M3Activity extends AppCompatActivity {
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.f1);
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        intent.setClass(M3Activity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("xsw", "m3 onstart");
    }
    
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("xsw", "m3 onrestart");
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("xsw", "m3 onresume");
    }
    
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("xsw", "m3 onNewIntant");
    }
    
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("xsw", "m3 onPause");
    }
    
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("xsw", "m3 onstop");
    }
}
