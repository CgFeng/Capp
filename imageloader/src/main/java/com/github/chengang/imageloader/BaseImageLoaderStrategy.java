package com.github.chengang.imageloader;

import android.content.Context;
import android.widget.ImageView;

/**
 * Created by fengchengang on 2017/4/10.
 * <p>
 * 图片加载接口规范
 */
public interface BaseImageLoaderStrategy {
    void loadImage(Context context, ImageView imageView);

    void clearMemory(Context context);
}
