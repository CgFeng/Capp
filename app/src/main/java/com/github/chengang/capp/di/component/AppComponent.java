package com.github.chengang.capp.di.component;

import android.content.Context;

import com.github.chengang.capp.di.App;
import com.github.chengang.capp.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by fengchengang on 2017/4/6.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    App getpplication();

    Context getContext();
}
