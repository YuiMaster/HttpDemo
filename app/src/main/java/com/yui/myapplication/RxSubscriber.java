package com.yui.myapplication;

import android.util.Log;

import com.trello.rxlifecycle.LifecycleProvider;
import com.yui.myapplication.api.BaseApi;

import java.lang.ref.SoftReference;

import rx.Subscriber;

/**
 * Subscriber 封装实现类
 * Subscriber：订阅者，预约者
 *
 * @author liaoyuhuan
 * @date on  2018/1/23
 * @email
 * @org
 * @describe 添加描述
 */

public class RxSubscriber<T> extends Subscriber<T> {
    /**
     * 软引用回调接口
     */
    private SoftReference<HttpOnNextCallback> mSubscriberOnNextListener;
    /**
     * 软引用反正内存泄露
     */
    private SoftReference<LifecycleProvider> lifeProvide;
    /**
     * 请求数据
     */
    private BaseApi mApi;

    public RxSubscriber(BaseApi api) {
        this.lifeProvide = new SoftReference<>(api.getLifeProvider());
    }


    /**
     * 取消ProgressDialog的时候，取消对observable的订阅，同时也取消了http请求
     */
    public void onCancelProgress() {
        if (!this.isUnsubscribed()) {
            this.unsubscribe();
        }
    }

    @Override
    public void onCompleted() {
        Log.w("lyh", "onCompleted");
        if (mSubscriberOnNextListener.get() != null) {
            mSubscriberOnNextListener.get().onComplete();
        }
    }

    @Override
    public void onError(Throwable e) {
        doErro(e);
        Log.w("lyh", "onError");
    }

    /**
     * 错误统一处理
     */
    private void doErro(Throwable e) {
        Throwable mThrowable = e.getCause();
        Log.w("lyh", "doErro");
        if (mSubscriberOnNextListener.get() != null) {
            mSubscriberOnNextListener.get().onError(mThrowable);
        }
    }

    @Override
    public void onNext(T t) {
        Log.w("lyh", "onNext ");
        if (mSubscriberOnNextListener.get() != null) {
            mSubscriberOnNextListener.get().onNext(t);
        }
    }

    public SoftReference<HttpOnNextCallback> getmSubscriberOnNextListener() {
        return mSubscriberOnNextListener;
    }

    public void setmSubscriberOnNextListener(SoftReference<HttpOnNextCallback> mSubscriberOnNextListener) {
        this.mSubscriberOnNextListener = mSubscriberOnNextListener;
    }
}

