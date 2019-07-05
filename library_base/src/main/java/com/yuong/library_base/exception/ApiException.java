package com.yuong.library_base.exception;

/**
 * Created by liukun on 16/3/10.
 */
public class ApiException extends Exception {

    /*错误码*/
    private int code;
    /*显示的信息*/
    private String displayMessage;
    public ApiException(Throwable e) {
        super(e);
    }

    public ApiException(Throwable cause, int code, String showMsg) {
        super(showMsg, cause);
        setCode(code);
        setDisplayMessage(showMsg);
    }

    public int getCode() {
        return code;
    }

    public String getDisplayMessage() {
        return displayMessage;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
    }
}

