package com.github.chengang.base.presenter;

import com.github.chengang.base.view.BaseView;

/**
 * Created by fengchengang on 2017/4/6.
 */

public interface BasePresenter<T extends BaseView> {

    void attachView(T view);

    void detachView();
}
