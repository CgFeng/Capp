package com.github.chengang.capp.business;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

import com.github.chengang.base.acitivity.BaseActivity;
import com.github.chengang.capp.R;

public class WelcomeActivity extends BaseActivity {

    private final String Tag = getClass().getName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setContentView(R.layout.activity_welcome);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent splashIntent = new Intent(WelcomeActivity.this, SplashActivity.class);
                startActivity(splashIntent);
                finish();
            }
        },1000);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void HandleIntent(Intent intent) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(Tag,"------------------------>>  WelcomeActivity is destoryed!");
    }
}
