package com.yui.libhttp.interceptor;

import android.content.Context;

import com.yui.libbase.utils.AppUtils;
import com.yui.libbase.utils.DeviceUtils;
import com.yui.libbase.utils.NetworkUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 头部拦截器
 *
 * @author liaoyuhuan
 * @date on  2018/1/23
 * @email
 * @org
 * @describe 添加描述
 */


public class HeaderInterceptor implements Interceptor {
    Context mCxt;

    public HeaderInterceptor(Context mCxt) {
        this.mCxt = mCxt;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        String type = DeviceUtils.getDeviceType();
        String appName = AppUtils.getAppPackgeName(mCxt);
        String appVersion = AppUtils.getVersionName(mCxt);
        String os = DeviceUtils.getOsVersion();
        String modle = DeviceUtils.getModel();
        String uuid = DeviceUtils.getUUID(mCxt);
        String network = NetworkUtils.getNetWorkTypeName(mCxt);

        Request request = chain.request();
        Request.Builder builder = request.newBuilder();
        Request newRequest = builder
                .addHeader("User-Agent", type)
                .addHeader("X-APP", appName)
                .addHeader("X-VER", appVersion)
                .addHeader("X-BUILD", modle)
                .addHeader("X-UUID", uuid)
                .addHeader("X-OS", os)
                .addHeader("X-NET", network)
                .build();
        return chain.proceed(newRequest);
    }
}