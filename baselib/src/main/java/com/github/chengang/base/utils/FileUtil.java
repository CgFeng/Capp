package com.github.chengang.base.utils;

import android.content.Context;
import android.os.storage.StorageManager;
import android.text.TextUtils;

import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by fengchengang on 2017/4/10.
 */

public class FileUtil {

    public static String getExtendedMemoryPath(Context mContext) {
        StorageManager mStorageManager = (StorageManager) mContext.getSystemService(Context.STORAGE_SERVICE);
        Class<?> storageVolumeClazz = null;
        try {
            storageVolumeClazz = Class.forName("android.os.storage.StorageVolume");
            Method getVolumeList = mStorageManager.getClass().getMethod("getVolumeList");
            Method getPath = storageVolumeClazz.getMethod("getPath");
            Method isRemovable = storageVolumeClazz.getMethod("isRemovable");
            Object result = getVolumeList.invoke(mStorageManager);
            final int length = Array.getLength(result);
            for (int i = 0; i < length; i++) {
                Object storageVolumeElement = Array.get(result, i);
                String path = (String) getPath.invoke(storageVolumeElement);
                boolean removable = (Boolean) isRemovable.invoke(storageVolumeElement);
                if (removable) {
                    return path;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 如果文件末尾有了"/"则判断是否有多个"/"，是则保留一个，没有则添加
     *
     * @param path
     * @return
     */
    public static String checkFileSeparator(String path) {
        if (!TextUtils.isEmpty(path)) {
            if (!path.endsWith(File.separator)) {
                return path.concat(File.separator);
            } else {
                final int sourceStringLength = path.length();
                int index = sourceStringLength;
                if (index >= 0) {
                    while (index >= 0) {
                        index--;
                        if (path.charAt(index) != File.separatorChar) {
                            break;
                        }
                    }
                }
                if (index < sourceStringLength) {
                    path = path.substring(0, index + 1);
                    return path.concat(File.separator);
                }
            }
        }
        return path;
    }
}
