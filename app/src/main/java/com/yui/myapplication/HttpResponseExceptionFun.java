package com.yui.myapplication;

import com.yui.myapplication.manager.ExecptionManager;

import rx.Observable;
import rx.functions.Func1;

/**
 * http请求异常处理
 *
 * @author liaoyuhuan
 * @date on  2018/1/23
 * @email
 * @org
 * @describe 添加描述
 */

public class HttpResponseExceptionFun<T> implements Func1<Throwable, Observable<T>> {
    @Override
    public Observable<T> call(Throwable throwable) {
        return Observable.error(ExecptionManager.getInstance().handleException(throwable));
    }
}