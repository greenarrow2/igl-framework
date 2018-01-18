package com.igl.gov.common.api;

import java.util.List;

/**
 * 单数据集响应类
 */
public class DataResult {

    private Boolean success = true;

    private Object obj;

    public  DataResult(){

    }

    public  DataResult(Object obj){
        this.obj = obj;
    }

    public DataResult(Boolean success,Object obj){
        this.success = success;
        this.obj = obj;
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
}
