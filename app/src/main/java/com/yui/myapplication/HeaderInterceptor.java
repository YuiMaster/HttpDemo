package com.yui.myapplication;

import android.content.Context;

import com.yui.myapplication.utils.AppUtils;
import com.yui.myapplication.utils.DeviceUtils;
import com.yui.myapplication.utils.NetworkUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Jane on 2018/1/22.
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