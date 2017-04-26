package com.github.chengang.imageloader.glide;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.module.GlideModule;

/**
 * Created by fengchengang on 2017/4/10.
 * <p>
 * Glide自定义配置
 */

public class GlideConfigModule implements GlideModule {
    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        //Glide默认配置的Bitmap Format 为 RGB_565，这样做为了降低内存消耗
        builder.setDecodeFormat(DecodeFormat.PREFER_ARGB_8888);
        //设置Disk缓存
//        builder.setDiskCache(new DiskLruCacheFactory(AppFileHelper.getAppCachePath(), 50 * 1024 * 1024));// TODO: 2017/4/10
        //设置内存缓存和 bitmap 池的大小
        MemorySizeCalculator calculator = new MemorySizeCalculator(context);
        int defaultMemoryCacheSize = calculator.getMemoryCacheSize();
        int defaultBitmapPoolSize = calculator.getBitmapPoolSize();

        int customMemoryCacheSize = (int) (1.2 * defaultMemoryCacheSize);
        int customBitmapPoolSize = (int) (1.2 * defaultBitmapPoolSize);

        builder.setMemoryCache( new LruResourceCache( customMemoryCacheSize ));
        builder.setBitmapPool( new LruBitmapPool( customBitmapPoolSize ));
    }

    @Override
    public void registerComponents(Context context, Glide glide) {

    }
}
