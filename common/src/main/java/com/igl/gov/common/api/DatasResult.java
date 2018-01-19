package com.igl.gov.common.api;

import com.igl.gov.common.utils.CommonMsgUtils;

public class DatasResult {

    private Boolean success = true;

    private Object obj;

    private Object other;

    private String message;

    public  DatasResult(){

    }

    public  DatasResult(Object obj){
        this.obj = obj;
        this.message = CommonMsgUtils.COMMON_SAVE_SUCCESS.getMsg();
    }

    public DatasResult(Boolean success,Object obj){
        this.success = success;
        this.obj = obj;
        if(success){
            this.message = CommonMsgUtils.COMMON_SAVE_SUCCESS.getMsg();
        }else{
            this.message = CommonMsgUtils.COMMON_SAVE_ERROR.getMsg();
        }
    }

    public DatasResult(Boolean success,Object obj,Object other){
        this.success = success;
        this.obj = obj;
        this.other = other;
        if(success){
            this.message = CommonMsgUtils.COMMON_SAVE_SUCCESS.getMsg();
        }else{
            this.message = CommonMsgUtils.COMMON_SAVE_ERROR.getMsg();
        }
    }

    public DatasResult(Boolean success,Object obj,Object other,String message){
        this.success = success;
        this.obj = obj;
        this.other = other;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public Object getOther() {
        return other;
    }

    public void setOther(Object other) {
        this.other = other;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
