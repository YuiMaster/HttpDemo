package com.yui.libhttp.interceptor;

import android.content.Context;

import com.yui.libhttp.constant.HttpConstants;
import com.yui.libbase.utils.StringUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 业务请求头拦截器
 *
 * @author liaoyuhuan
 * @date on  2018/1/23
 * @email
 * @org
 * @describe 添加描述
 */


public class YdbHeaderInterceptor implements Interceptor {
    Context mCxt;

    public YdbHeaderInterceptor(Context mCxt) {
        this.mCxt = mCxt;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder builder = request.newBuilder();
        String token = "4b539985-5e7c-4d0d-9291-de51639cd1db";
        if (!StringUtils.isEmpty(token)) {
            Request newRequest = builder
                    .addHeader(HttpConstants.TOKEN, token)
                    .build();
            return chain.proceed(newRequest);
        }
        return chain.proceed(request);
    }
}
