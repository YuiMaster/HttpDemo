package com.yui.libhttp.execption;

/**
 * API 调用异常
 *
 * @author liaoyuhuan
 * @date on  2018/1/23
 * @email
 * @org
 * @describe 添加描述
 */


public class ApiExecption extends RuntimeException {
    /**
     * 错误码
     */
    public int code;
    /**
     * 错误内容
     */
    public String msg;

    public ApiExecption(int code, String message) {
        msg = message;
        this.code = code;
    }

    @Override
    public String getMessage() {
        return msg;
    }

    public int getCode() {
        return code;
    }


}