package com.igl.gov.common.utils;

import com.igl.gov.common.api.DataGridResult;
import com.igl.gov.common.api.DataListResult;
import com.igl.gov.common.api.DataResult;
import com.igl.gov.common.api.DatasResult;

import java.util.List;

/**
 * 前端返回结果响应工具
 *  fancr
 */
public class ResponseUtils {

    private ResponseUtils(){

    }

    public static DataResult success(Object obj){
        return new DataResult(true,obj);
    }

    public static DatasResult success(Object obj,String message){
        return new DatasResult(true,obj,message);
    }

    public static DataListResult success(List items){
        return new DataListResult(true,items);
    }

    public static DataListResult success(List items,String message){
        return new DataListResult(true,items,message);
    }

    public static DataResult error(DataResult result){
        if(result == null){
            result = new DataResult(false);
        }
        return result;
    }

    public static DatasResult error(DatasResult result){
        if(result == null){
            result = new DatasResult(false);
        }
        return result;
    }

    public static DataListResult error(DataListResult result){
        if(result == null){
            result = new DataListResult(false);
        }
        return result;
    }


}
