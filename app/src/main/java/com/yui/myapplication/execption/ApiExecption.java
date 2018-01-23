package com.yui.myapplication.execption;

/**
 * API 调用异常
 * Created by Jane on 2018/1/22.
 */

public class ApiExecption extends RuntimeException {
    public int code;
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