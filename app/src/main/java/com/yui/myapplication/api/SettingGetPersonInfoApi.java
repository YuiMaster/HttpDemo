package com.yui.myapplication.api;

import com.trello.rxlifecycle.LifecycleProvider;
import com.yui.myapplication.BaseApi;
import com.yui.myapplication.SettingPersonInfoBean;
import com.yui.myapplication.SettingService;

import javax.inject.Inject;

import retrofit2.Retrofit;
import rx.Observable;

/**
 * Created by Jane on 2018/1/22.
 */
public class SettingGetPersonInfoApi extends BaseApi<SettingPersonInfoBean> {

    @Inject
    public SettingGetPersonInfoApi(LifecycleProvider lifecycleProvider, Retrofit retrofit) {
        super(lifecycleProvider, retrofit);
    }


    @Override
    public Observable getObservable() {
        SettingService service = getRetrofit().create(SettingService.class);
        return service.getPersonInfo();
    }

}
