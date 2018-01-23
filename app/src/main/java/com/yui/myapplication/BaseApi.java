package com.yui.myapplication;

import android.support.v7.app.AppCompatDialogFragment;

import com.trello.rxlifecycle.LifecycleProvider;
import com.yui.myapplication.constant.Constants;

import java.lang.ref.SoftReference;

import retrofit2.Retrofit;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Jane on 2018/1/22.
 */

public abstract class BaseApi<T> implements Func1<HttpResponseEntity<T>, T> {
    private final String TAG = this.getClass().getSimpleName();
    /**
     * rx生命周期管理
     */
    private SoftReference<LifecycleProvider> lifecycleProvider;
    /**
     * 回调
     */
    private SoftReference<HttpOnNextCallback> callback;
    /**
     * 是否显示加载框(用于提交任务的dialog)
     */
    private boolean showProgressDialog;
    /**
     * 加载对话框
     */
    private AppCompatDialogFragment progressDialog;
    /**
     * 是否显示加载中View 页面初次进入的加载View
     */
    private boolean showVaryLoadingView;
    private Retrofit retrofit;

    public BaseApi(LifecycleProvider lifecycleProvider, Retrofit retrofit) {
        setLifeProvider(lifecycleProvider);
        setRetrofit(retrofit);
        setShowVaryLoadingView(false);
        setShowProgressDialog(false);
    }

    public BaseApi(LifecycleProvider lifecycleProvider) {
        setLifeProvider(lifecycleProvider);
        setShowVaryLoadingView(false);
        setShowProgressDialog(false);
    }


    public boolean isShowProgressDialog() {
        return showProgressDialog;
    }

    public void setShowProgressDialog(boolean showProgressDialog) {
        this.showProgressDialog = showProgressDialog;
    }

    public boolean isShowVaryLoadingView() {
        return showVaryLoadingView;
    }

    public void setShowVaryLoadingView(boolean showVaryLoadingView) {
        this.showVaryLoadingView = showVaryLoadingView;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public void setRetrofit(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    public SoftReference<HttpOnNextCallback> getCallback() {
        return callback;
    }

    public void setCallback(HttpOnNextCallback callback) {
        this.callback = new SoftReference<HttpOnNextCallback>(callback);
    }

    public AppCompatDialogFragment getProgressDialog() {
        return progressDialog;
    }

    public void setProgressDialog(AppCompatDialogFragment progressDialog) {
        this.progressDialog = progressDialog;
    }

    /**
     * 获取Rx生命周期
     */
    public LifecycleProvider getLifeProvider() {
        return lifecycleProvider.get();
    }

    public void setLifeProvider(LifecycleProvider provider) {
        this.lifecycleProvider = new SoftReference<LifecycleProvider>(provider);
    }


    public abstract Observable getObservable();

    /**
     * http状态是否正常
     *
     * @param nCode
     *
     * @return
     */
    private boolean isValidStatus(int nCode) {
        switch (nCode) {
            case Constants.Http.HTTP_OK_STATUS:
            case Constants.Http.HTTP_GET_LICENC_OK:
                return true;
            default:
                return false;
        }
    }

    @Override
    public T call(HttpResponseEntity<T> tHttpResponseEntity) {
        if (!isValidStatus(tHttpResponseEntity.getCode())) {
            throw new ApiExecption(tHttpResponseEntity.getCode(), tHttpResponseEntity.getMsg() != null ? tHttpResponseEntity.getMsg() : "");
        }
        return tHttpResponseEntity.getData();
    }
}

