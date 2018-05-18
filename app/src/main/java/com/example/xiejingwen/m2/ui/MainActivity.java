package com.example.xiejingwen.m2.ui;

import com.example.xiejingwen.m2.R;
import com.example.xiejingwen.m2.TimeLog;
import com.example.xiejingwen.m2.presenter.IPresenter;
import com.example.xiejingwen.m2.presenter.MyPresenter;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.drawable.ScaleDrawable;
import android.os.Bundle;
import android.os.Debug;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements ISetTxt {
    final FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction transaction = fragmentManager.beginTransaction();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        LinearLayout layout = findViewById(R.id.top_layout);
        layout.setPadding(0, getStatusBarHeight(), 0, 0);
        toolbar.setVisibility(View.GONE);

        ImageView imageView= findViewById(R.id.imgView);
        imageView.setImageLevel(1);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, M2Activity.class);
                startActivity(intent);
            }
        });
        Log.d("xsw", "onCreate");
    }

    @TimeLog(value = "MMMM", a = 1000)
    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("xsw", "onstart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("xsw", "onrestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("xsw", "onresume");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("xsw", "onNewIntant");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("xsw", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("xsw", "onstop");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem menuItem = menu.add("tst");
        menuItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void setText(String text) {
        new MyPresenter(this);
    }
    
    @Override
    public void setPresenter(IPresenter presenter) {
        
    }
}
