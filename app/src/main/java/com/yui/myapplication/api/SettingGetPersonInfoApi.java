package com.yui.myapplication.api;

import com.trello.rxlifecycle.LifecycleProvider;
import com.yui.libhttp.api.BaseApi;
import com.yui.myapplication.bean.SettingPersonInfoBean;
import com.yui.myapplication.SettingService;

import javax.inject.Inject;

import retrofit2.Retrofit;
import rx.Observable;

/**
 * 取得跟人信息的请求
 *
 * @author liaoyuhuan
 * @date on  2018/1/23
 * @email
 * @org
 * @describe 添加描述
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
