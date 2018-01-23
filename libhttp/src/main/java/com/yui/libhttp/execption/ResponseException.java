package com.yui.libhttp.execption;


/**
 * 统一的返回异常
 *
 * @author liaoyuhuan
 * @date on  2018/1/23
 * @email
 * @org
 * @describe 添加描述
 */

public class ResponseException extends Exception {
    /**
     * 错误码
     */
    public int code;
    /**
     * 错误内容
     */
    public String message;

    public ResponseException(Throwable throwable, int code) {
        super(throwable);
        this.code = code;

    }

}
