package com.github.chengang.capp.di;

import android.app.Application;

import com.github.chengang.capp.di.component.AppComponent;
import com.github.chengang.capp.di.component.DaggerAppComponent;
import com.github.chengang.capp.di.module.AppModule;

/**
 * Created by fengchengang on 2017/4/6.
 * <p>
 * 全局应用
 */

public class App extends Application {

    private static final String TAG = "App";

    private AppComponent mAppComponent;

    private static App mApp;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        mApp = this;
    }

    public static App getInstance(){
        return mApp;
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
