package com.yui.libhttp.manager;

import android.net.ParseException;

import com.google.gson.JsonParseException;
import com.yui.libhttp.constant.ErrorConstants;
import com.yui.libhttp.execption.ApiExecption;
import com.yui.libhttp.execption.ResponseException;

import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import retrofit2.adapter.rxjava.HttpException;

/**
 * 异常处理
 *
 * @author liaoyuhuan
 * @date on  2018/1/23
 * @email
 * @org
 * @describe 添加描述
 */

public class ExecptionManager {
    private volatile static ExecptionManager INSTANCE;
    private final String TAG = this.getClass().getSimpleName();

    private ExecptionManager() {
    }

    /**
     * 获取单例
     */
    public static ExecptionManager getInstance() {
        if (INSTANCE == null) {
            synchronized (ExecptionManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ExecptionManager();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * 是否是网络异常
     *
     * @param throwable
     *
     * @return
     */
    public boolean isNetException(Throwable throwable) {
        if (throwable instanceof ConnectException) {
            return true;
        }
        if (throwable instanceof ConnectTimeoutException) {
            return true;
        }

        return throwable instanceof SocketTimeoutException;
    }


    /**
     * 是否是服务器异常
     */
    public boolean isApiException(Throwable throwable) {
        return throwable instanceof ApiExecption;
    }

    /**
     * 是Http 请求异常
     */
    public boolean isHttpException(Throwable throwable) {
        return throwable instanceof HttpException;
    }


    /**
     * 异常分类并进行 数据转化
     *
     * @param e
     *
     * @return
     */
    public ResponseException handleException(Throwable e) {
        ResponseException ex;
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            ex = new ResponseException(e, ErrorConstants.HTTP_ERROR);
            switch (httpException.code()) {
                case ErrorConstants.UNAUTHORIZED:
                case ErrorConstants.FORBIDDEN:
                case ErrorConstants.NOT_FOUND:
                case ErrorConstants.REQUEST_TIMEOUT:
                case ErrorConstants.GATEWAY_TIMEOUT:
                case ErrorConstants.INTERNAL_SERVER_ERROR:
                case ErrorConstants.BAD_GATEWAY:
                case ErrorConstants.SERVICE_UNAVAILABLE:
                default:
                    ex.message = "网络错误";
                    break;
            }
            return ex;
        } else if (e instanceof ApiExecption) {
            ApiExecption resultException = (ApiExecption) e;
            ex = new ResponseException(resultException, resultException.code);
            ex.message = resultException.msg;
            return ex;
        } else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException) {
            ex = new ResponseException(e, ErrorConstants.PARSE_ERROR);
            ex.message = "解析错误";
            return ex;
        } else if (e instanceof ConnectException) {
            ex = new ResponseException(e, ErrorConstants.NETWORD_ERROR);
            ex.message = "连接失败";
            return ex;
        } else if (e instanceof javax.net.ssl.SSLHandshakeException) {
            ex = new ResponseException(e, ErrorConstants.SSL_ERROR);
            ex.message = "证书验证失败";
            return ex;
        } else if (e instanceof ConnectTimeoutException) {
            ex = new ResponseException(e, ErrorConstants.TIMEOUT_ERROR);
            ex.message = "连接超时";
            return ex;
        } else if (e instanceof java.net.SocketTimeoutException) {
            ex = new ResponseException(e, ErrorConstants.TIMEOUT_ERROR);
            ex.message = "连接超时";
            return ex;
        } else {
            ex = new ResponseException(e, ErrorConstants.UNKNOWN);
            ex.message = "未知错误";
            return ex;
        }
    }

}