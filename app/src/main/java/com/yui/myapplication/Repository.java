package com.yui.myapplication;

import com.yui.myapplication.api.BaseApi;
import com.yui.myapplication.manager.HttpManager;

import rx.Observable;

/**
 * Created by Jane on 2018/1/22.
 */

public class Repository {
    private HttpManager httpManager;

    public Repository( HttpManager mHttpManager) {
        this.httpManager = mHttpManager;

    }
    public void requestRemoteData(BaseApi api) {
        RxSubscriber subscriber = new RxSubscriber(api);
        Observable netObservable = httpManager.doNormalHttp(api);
        netObservable.subscribe(subscriber);
    }
}
