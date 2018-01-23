package com.yui.myapplication;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.trello.rxlifecycle.android.ActivityEvent;
import com.trello.rxlifecycle.android.FragmentEvent;
import com.yui.myapplication.constant.Constants;
import com.yui.myapplication.utils.CacheUtils;
import com.yui.myapplication.utils.HttpsUtils;

import java.io.InputStream;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by Jane on 2018/1/22.
 */

public class HttpManager<T, T1, T2> {
    private static final String TAG = HttpManager.class.getSimpleName();


    public OkHttpClient getOkhttpClient(Context context, Interceptor interceptor) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        if (true) {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        }
        long maxCacheSize = 1000 * 1000 * 50;
        Cache cache = new Cache(CacheUtils.getOkHttpFile(context), maxCacheSize);
        OkHttpClient.Builder builder = null;
        try {
            InputStream is = null;
            is = context.getResources().getAssets().open("server.cer");

            InputStream[] inputStreams = new InputStream[]{is};

            HttpsUtils.SSLParams sslParams = HttpsUtils.getSslSocketFactory(inputStreams, null, null);

            builder = new OkHttpClient.Builder()
                    /**session,cookie 持久化*/
                    .cookieJar(new PersistentCookieJar(new SetCookieCache(),
                            new SharedPrefsCookiePersistor(context)))
                    .addInterceptor(new HeaderInterceptor(context))
                    /**缓存 okhttp3 本来是存在的不设置不起作用*/
                    .cache(cache)
                    .addInterceptor(new CacheInterceptor(context))
                    .sslSocketFactory(sslParams.sSLSocketFactory, sslParams.trustManager)
                    .addInterceptor(new HttpLoggingInterceptor())
                    .addInterceptor(interceptor);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return builder.build();
    }


    /**
     * 普通的请求
     *
     * @param baseApi
     *
     * @return
     */
    public Observable doNormalHttp(BaseApi baseApi) {
        Observable observable = baseApi.getObservable()
                .retryWhen(new RetryWhenFun())
                .compose(baseApi.getLifeProvider() instanceof Fragment ?
                        baseApi.getLifeProvider().bindUntilEvent(FragmentEvent.DESTROY) :
                        baseApi.getLifeProvider().bindUntilEvent(ActivityEvent.DESTROY))
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(baseApi).onErrorResumeNext(new HttpResponseExceptionFun());
        return observable;
    }


    public Retrofit getRetrofit(OkHttpClient client) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.Http.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();
        return retrofit;
    }

}
