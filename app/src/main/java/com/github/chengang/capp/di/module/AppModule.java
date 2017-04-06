package com.github.chengang.capp.di.module;

import android.app.Application;
import android.content.Context;

import com.github.chengang.capp.di.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by fengchengang on 2017/4/6.
 */

@Module
public class AppModule {

    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    App provideApplication() {
        return (App) context.getApplicationContext();
    }

    @Provides
    @Singleton
    Context provideContext() {
        return context;
    }

}
