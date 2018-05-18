package com.example.xiejingwen.m2.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.xiejingwen.m2.R;

/**
 * Created by xiejingwen on 2018/5/17.
 */

public class M2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.f1);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.setClass(M2Activity.this, M3Activity.class);
                startActivity(intent);
            }
        }, 2000);

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("xsw", "m2 onstart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("xsw", "m2 onrestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("xsw", "m2 onresume");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("xsw", "m2 onNewIntant");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("xsw", "m2 onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("xsw", "m2 onstop");
    }
}
