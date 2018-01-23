package com.yui.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.trello.rxlifecycle.LifecycleProvider;
import com.trello.rxlifecycle.LifecycleTransformer;
import com.yui.myapplication.api.SettingGetPersonInfoApi;

import java.lang.ref.SoftReference;

import javax.annotation.Nonnull;
import javax.inject.Inject;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Inject
    HttpManager httpManager;

    private Retrofit mRetrofit;
    private LifecycleProvider mLifecycleProvider;

    @Inject
    SettingGetPersonInfoApi mSettingGetPersonInfoApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        httpManager = new HttpManager();
        mLifecycleProvider = new LifecycleProvider() {
            @Nonnull
            @Override
            public Observable lifecycle() {
                return null;
            }

            @Nonnull
            @Override
            public LifecycleTransformer bindUntilEvent(@Nonnull Object event) {
                return null;
            }

            @Nonnull
            @Override
            public LifecycleTransformer bindToLifecycle() {
                return null;
            }
        };
        mSettingGetPersonInfoApi = new SettingGetPersonInfoApi(mLifecycleProvider, mRetrofit);
        requestRemoteData(mSettingGetPersonInfoApi);
    }

    public Observable doNormalHttp(BaseApi baseApi) {
        Observable observable = getObservable()
                .retryWhen(new RetryWhenFun())
//                .compose(mLifecycleProvider.bindUntilEvent(ActivityEvent.DESTROY))
//                .compose(baseApi.getLifeProvider() instanceof Fragment ?
//                        baseApi.getLifeProvider().bindUntilEvent(FragmentEvent.DESTROY) :
//                        baseApi.getLifeProvider().bindUntilEvent(ActivityEvent.DESTROY))
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(baseApi).onErrorResumeNext(new HttpResponseExceptionFun());
        return observable;
    }

    /**
     * 普通请求远程网络数据
     */
    public void requestRemoteData(BaseApi api) {
        RxSubscriber subscriber = new RxSubscriber(api);
        subscriber.setmSubscriberOnNextListener(new SoftReference<HttpOnNextCallback>(callBack));
        Observable netObservable = doNormalHttp(api);
        netObservable.subscribe(subscriber);
    }


    Retrofit provideRetrofit(HttpManager httpManager, Context context) {
        YdbHeaderInterceptor ydbHeaderInterceptor = new YdbHeaderInterceptor(context);
        OkHttpClient client = httpManager.getOkhttpClient(context, ydbHeaderInterceptor);
        return httpManager.getRetrofit(client);
    }

    public Observable getObservable() {
        mRetrofit = provideRetrofit(httpManager, this.getApplicationContext());
        SettingService service = mRetrofit.create(SettingService.class);
        return service.getPersonInfo();
    }

    HttpOnNextCallback<SettingPersonInfoBean> callBack = new HttpOnNextCallback<SettingPersonInfoBean>() {

        @Override
        public void onNext(SettingPersonInfoBean bean) {
            Log.w("lyh", "callBack " + bean);
        }

        @Override
        public void onError(Throwable e) {
            Log.w("lyh", "onError " + e);
        }
    };
}
