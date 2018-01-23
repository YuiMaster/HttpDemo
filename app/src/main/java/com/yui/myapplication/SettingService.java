package com.yui.myapplication;

import com.yui.myapplication.constant.ApiConstants;

import retrofit2.http.GET;
import rx.Observable;

/**
 * @author liaoyuhuan
 * @date on  2018/1/22
 * @email
 * @org
 * @describe 添加描述
 */

public interface SettingService {

    @GET(ApiConstants.SETTING_PERSON_INFO_PATH)
    Observable<HttpResponseEntity<SettingPersonInfoBean>> getPersonInfo();
}
