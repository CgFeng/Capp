package com.github.chengang.base.manager;

import android.os.Environment;
import android.text.TextUtils;

import com.github.chengang.base.AppContext;
import com.github.chengang.base.utils.FileUtil;

import java.io.File;

/**
 * Created by fengchengang on 2017/4/10.
 */

public class FileManager {

    private static final String TAG = "FileManager";

    public static final String ROOT_PATH = "capp/github/chengang/";
    public static final String DATA_PATH = ROOT_PATH + ".data/";
    public static final String CACHE_PATH = ROOT_PATH + ".cache/";
    public static final String PIC_PATH = ROOT_PATH + ".pic/.nomedia/";
    public static final String LOG_PATH = ROOT_PATH + ".log/";
    public static final String TEMP_PATH = ROOT_PATH + ".temp/";

    private static String storagePath;

    public static void initStoragePath() {
        if (TextUtils.isEmpty(storagePath)) {
            storagePath = FileUtil.getExtendedMemoryPath(AppContext.getAppContext());
            if (TextUtils.isEmpty(storagePath)) {
                storagePath = Environment.getExternalStorageDirectory().getAbsolutePath();
                if (TextUtils.isEmpty(storagePath)) {
                    storagePath = AppContext.getAppContext().getFilesDir().getAbsolutePath();
                }
            }
        }

        storagePath = FileUtil.checkFileSeparator(storagePath);

        File rootDir = new File(storagePath.concat(ROOT_PATH));
        checkAndMakeDir(rootDir);

        File dataDir = new File(storagePath.concat(DATA_PATH));
        checkAndMakeDir(dataDir);

        File cacheDir = new File(storagePath.concat(CACHE_PATH));
        checkAndMakeDir(cacheDir);

        File picDir = new File(storagePath.concat(PIC_PATH));
        checkAndMakeDir(picDir);

        File logDir = new File(storagePath.concat(LOG_PATH));
        checkAndMakeDir(logDir);

        File tempDir = new File(storagePath.concat(TEMP_PATH));
        checkAndMakeDir(tempDir);

    }

    private static void checkAndMakeDir(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public static String getAppStoragePath() {
        return storagePath;
    }

    public static String getAppDataPath() {
        return storagePath.concat(DATA_PATH);
    }


    public static String getAppCachePath() {
        return storagePath.concat(CACHE_PATH);
    }

    public static String getAppPicPath() {
        return storagePath.concat(PIC_PATH);
    }

    public static String getAppLogPath() {
        return storagePath.concat(LOG_PATH);
    }

    public static String getAppTempPath() {
        return storagePath.concat(TEMP_PATH);
    }
}
