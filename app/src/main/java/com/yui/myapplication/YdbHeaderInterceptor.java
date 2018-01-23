package com.yui.myapplication;

import android.content.Context;

import com.yui.myapplication.constant.Constants;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Jane on 2018/1/22.
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
                    .addHeader(Constants.TOKEN, token)
                    .build();
            return chain.proceed(newRequest);
        }
        return chain.proceed(request);
    }
}
