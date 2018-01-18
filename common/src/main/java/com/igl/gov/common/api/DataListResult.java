package com.igl.gov.common.api;

import java.util.List;

/**
 * 多数据集响应结果类
 * @param <T>
 */
public class DataListResult<T> {

    private Boolean success = true;

    private List<T> list;

    public DataListResult(){

    }

    public DataListResult(List<T> list){
        this.list = list;
    }

    public DataListResult(Boolean success,List<T> list){
          this.success = success;
          this.list = list;
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
}
