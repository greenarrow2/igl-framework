package com.igl.gov.common.api;

public class DatasResult {

    private Boolean success = true;

    private Object obj;

    private Object other;

    public  DatasResult(){

    }

    public  DatasResult(Object obj){
        this.obj = obj;
    }

    public DatasResult(Boolean success,Object obj){
        this.success = success;
        this.obj = obj;
    }

    public DatasResult(Boolean success,Object obj,Object other){
        this.success = success;
        this.obj = obj;
        this.other = other;
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
}
