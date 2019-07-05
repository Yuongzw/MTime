package com.yuong.library_base.exception;

import android.util.Log;

import com.google.gson.JsonParseException;
import com.google.gson.stream.MalformedJsonException;
import com.yuong.library_base.MyConstants;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import retrofit2.HttpException;

public class ApiExceptionFactory {

    private final static String TAG = "ApiExceptionFactory";
    public static ApiException getApiException(Throwable e) {
        Log.e(TAG, e.getClass().getName());
        ApiException apiException = new ApiException(e);
        String msg;
        int code;
        if (e instanceof ConnectException) {
            msg = "无法连接服务器！";
            code = MyConstants.NETWORD_ERROR;
        } else if (e instanceof JsonParseException) {
            msg = "服务器返回错误！";
            code = MyConstants.JSON_ERROR;
        } else if (e instanceof SocketTimeoutException) {
            msg = "连接服务器超时！\"";
            code = MyConstants.CONNECT_ERROR;
        } else if (e instanceof HttpException) {
            msg = "404错误(网址不存在)！";
            code = MyConstants.ERROR404;
        } else {
            msg = "未知错误！";
            code = MyConstants.UNKNOWN_ERROR;
        }
        apiException.setCode(code);
        apiException.setDisplayMessage(msg);
        return apiException;
    }
}
