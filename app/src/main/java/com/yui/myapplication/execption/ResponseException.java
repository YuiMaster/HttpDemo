package com.yui.myapplication.execption;

/**
 * Created by Jane on 2018/1/22.
 */
public class ResponseException extends Exception {
    public int code;
    public String message;

    public ResponseException(Throwable throwable, int code) {
        super(throwable);
        this.code = code;

    }

}
