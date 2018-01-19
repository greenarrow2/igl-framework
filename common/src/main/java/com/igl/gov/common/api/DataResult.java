package com.igl.gov.common.api;

import com.igl.gov.common.utils.CommonMsgUtils;

import java.util.List;

/**
 * 单数据集响应类
 */
public class DataResult {

    private Boolean success = true;

    private Object obj;

    private String message;

    public  DataResult(){

    }

    public  DataResult(Object obj){
        this.obj = obj;
        this.message = CommonMsgUtils.COMMON_SAVE_SUCCESS.getMsg();
    }

    public DataResult(Boolean success,Object obj){
        this.success = success;
        this.obj = obj;
        if(success){
            this.message = CommonMsgUtils.COMMON_SAVE_SUCCESS.getMsg();
        }else{
            this.message = CommonMsgUtils.COMMON_SAVE_ERROR.getMsg();
        }
    }

    public DataResult(Boolean success,Object obj,String message){
        this.success = success;
        this.obj = obj;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
