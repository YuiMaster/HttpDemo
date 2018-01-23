package com.yui.myapplication;

/**
 * http请求
 * 成功回调处理
 *
 * @author liaoyuhuan
 * @date on  2018/1/23
 * @email
 * @org
 * @describe 添加描述
 */


public abstract class HttpOnNextCallback<T> {
    /**
     * 成功回调
     *
     * @param t
     */
    public abstract void onNext(T t);

    /**
     * 失败或者错误方法
     * 主动调用，更加灵活
     *
     * @param e
     */
    public void onError(Throwable e) {

    }

    /**
     * 取消回調
     */
    public void onCancel() {

    }

    /**
     * 完成回调
     */
    public void onComplete() {

    }

}
