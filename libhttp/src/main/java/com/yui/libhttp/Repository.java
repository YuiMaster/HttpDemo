package com.yui.libhttp;

import com.yui.libhttp.api.BaseApi;
import com.yui.libhttp.manager.HttpManager;

import rx.Observable;

/**
 * 数据仓库，所有数据请求入口。
 * 将请求从fragment中剥离出来，建议初始化时，数据使用Activity/Application的context
 *
 * @author liaoyuhuan
 * @date on  2018/1/23
 * @email
 * @org
 * @describe 添加描述
 */


public class Repository {
    private HttpManager httpManager;

    public Repository(HttpManager mHttpManager) {
        this.httpManager = mHttpManager;

    }

    public void requestRemoteData(BaseApi api) {
        RxSubscriber subscriber = new RxSubscriber(api);
        Observable netObservable = httpManager.doNormalHttp(api);
        netObservable.subscribe(subscriber);
    }
}
