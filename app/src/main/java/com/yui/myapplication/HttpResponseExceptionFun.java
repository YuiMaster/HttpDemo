package com.yui.myapplication;

import com.yui.myapplication.manager.ExecptionManager;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Jane on 2018/1/22.
 */

public class HttpResponseExceptionFun<T> implements Func1<Throwable, Observable<T>> {
    @Override
    public Observable<T> call(Throwable throwable) {
        return Observable.error(ExecptionManager.getInstance().handleException(throwable));
    }
}