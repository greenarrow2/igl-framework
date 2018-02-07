package com.igl.gov.common.utils;

public class ResultUtils {

    private boolean success;

    private Object obj;

    private String message;

    public ResultUtils() {
    }

    public ResultUtils(boolean success, Object obj, String message) {
        this.success = success;
        this.obj = obj;
        this.message = message;
    }

    public ResultUtils(boolean success, Object obj) {
        this.success = success;
        this.obj = obj;
    }

    public ResultUtils(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
