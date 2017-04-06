package com.github.chengang.base.acitivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by fengchengang on 2017/3/30.
 * <p>
 * BaseActivity
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        HandleIntent(getIntent());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @CallSuper
    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }


    /*------------------------抽象方法------------------------*/

    /**
     * init view here
     */
    protected abstract void initView();

    /**
     * init data here
     */
    protected abstract void initData();

    /**
     * 处理传递过来的intent
     * @param intent intent
     */
    protected abstract void HandleIntent(Intent intent);
}
