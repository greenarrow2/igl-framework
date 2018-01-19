package com.igl.gov.common.utils;

public enum CommonMsgUtils {

    COMMON_SAVE_ERROR(0,"保存失败！"),
    COMMON_SAVE_SUCCESS(1,"保存成功！");

    private int state;
    private String msg;

    

    CommonMsgUtils(int state, String msg) {
        this.state = state;
        this.msg = msg;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
