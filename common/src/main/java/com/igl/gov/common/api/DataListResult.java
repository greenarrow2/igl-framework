package com.igl.gov.common.api;

import com.igl.gov.common.utils.CommonMsgUtils;

import java.util.List;

/**
 * 多数据集响应结果类
 * @param <T>
 */
public class DataListResult<T> {

    private Boolean success = true;

    private List<T> list;

    private String message;

    public DataListResult(){

    }

    public DataListResult(Boolean success){
           this.success = success;
        if(success){
            this.message = CommonMsgUtils.COMMON_SAVE_SUCCESS.getMsg();
        }else{
            this.message = CommonMsgUtils.COMMON_SAVE_ERROR.getMsg();
        }
    }

    public DataListResult(List<T> list){
        this.list = list;
        this.message = CommonMsgUtils.COMMON_SAVE_SUCCESS.getMsg();
    }

    public DataListResult(Boolean success,List<T> list){
          this.success = success;
          this.list = list;
        if(success){
            this.message = CommonMsgUtils.COMMON_SAVE_SUCCESS.getMsg();
        }else{
            this.message = CommonMsgUtils.COMMON_SAVE_ERROR.getMsg();
        }
    }

    public DataListResult(Boolean success,List<T> list,String message){
        this.success = success;
        this.list = list;
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
