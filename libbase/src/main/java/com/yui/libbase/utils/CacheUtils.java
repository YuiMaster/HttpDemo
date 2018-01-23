package com.yui.libbase.utils;


import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.text.TextUtils;

import java.io.File;
import java.io.IOException;

import static android.os.Environment.MEDIA_MOUNTED;

/**
 * 缓存和文件目录位置
 *
 * @author liaoyuhuan
 * @date on  2018/1/23
 * @email
 * @org
 * @describe 添加描述
 */


public class CacheUtils {

    /**
     * SD卡是否存在
     *
     * @return
     */
    public static boolean isSDCardExsit() {
        String state = Environment.getExternalStorageState();
        if (state == null) return false;
        return MEDIA_MOUNTED.equals(state);
    }

    public static String getDiskCacheDir(Context context) {
        String cachePath = null;
        if (isSDCardExsit()) {
            if (context.getExternalCacheDir() != null) {
                cachePath = context.getExternalCacheDir().getPath();
            }
        } else {
            if (context.getCacheDir() != null) {
                cachePath = context.getCacheDir().getPath();
            }
        }
        return cachePath;
    }


    /**
     * 录音文件存放位置
     *
     * @param context
     *
     * @return
     */
    public static String getRecoderDiskFileDir(Context context) {
        String cachePath = null;
        if (isSDCardExsit()) {
            cachePath = context.getExternalFilesDir("recoder").getPath();
        } else {
            cachePath = context.getFilesDir().getPath();
        }
        return cachePath;
    }


    /**
     * 马赛克图片文件存放位置
     *
     * @param context
     *
     * @return
     */
    public static String getMosickDiskFileDir(Context context) {
        String cachePath = null;
        if (isSDCardExsit()) {
            cachePath = context.getExternalFilesDir("mosaic").getPath();
        } else {
            cachePath = context.getFilesDir().getPath();
        }
        return cachePath;
    }


    /**
     * 获得裁剪的存储位置
     *
     * @param context
     *
     * @return
     */
    public static String getUCropDiskFileDir(Context context) {
        String cachePath = null;
        if (isSDCardExsit()) {
            cachePath = context.getExternalFilesDir("uCrop").getPath();
        } else {
            cachePath = context.getFilesDir().getPath();
        }
        return cachePath;
    }


    public static File getOkHttpFile(Context context) {
        String path = getCacheDirectory(context, true) + File.separator + "okhttp";
        File file = new File(path);
        return file;
    }


    public static File createCameraFile(Context context) throws IOException {
        File dir = null;
        if (TextUtils.equals(Environment.getExternalStorageState(), MEDIA_MOUNTED)) {
            dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
            if (!dir.exists()) {
                dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM + "/Camera");
                if (!dir.exists()) {
                    dir = getCacheDirectory(context, true);
                }
            }
        } else {
            dir = getCacheDirectory(context, true);
        }
        return File.createTempFile("IMG_", ".jpg", dir);
    }


    /**
     * 获得缓存目录
     *
     * @param preferExternal 是否选择外部存储卡
     */
    public static File getCacheDirectory(Context context, boolean preferExternal) {
        File appCacheDir = null;
        String externalStorageState;
        try {
            externalStorageState = Environment.getExternalStorageState();
        } catch (NullPointerException e) {
            externalStorageState = "";
        } catch (IncompatibleClassChangeError e) {
            externalStorageState = "";
        }
        if (preferExternal && MEDIA_MOUNTED.equals(externalStorageState) && hasExternalStoragePermission(context)) {
            appCacheDir = getExternalCacheDir(context);
        }
        if (appCacheDir == null) {
            appCacheDir = context.getCacheDir();
        }
        if (appCacheDir == null) {
            String cacheDirPath = "/data/data/" + context.getPackageName() + "/cache/";
            appCacheDir = new File(cacheDirPath);
        }
        return appCacheDir;
    }


    private static File getExternalCacheDir(Context context) {
        File dataDir = new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data");
        File appCacheDir = new File(new File(dataDir, context.getPackageName()), "cache");
        if (!appCacheDir.exists()) {
            if (!appCacheDir.mkdirs()) {
                return null;
            }
            try {
                new File(appCacheDir, ".nomedia").createNewFile();
            } catch (IOException e) {
            }
        }
        return appCacheDir;
    }

    /**
     * 是否有写权限
     *
     * @param context
     *
     * @return
     */
    private static boolean hasExternalStoragePermission(Context context) {
        int perm = context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE");
        return perm == PackageManager.PERMISSION_GRANTED;
    }


}

