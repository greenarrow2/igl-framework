package com.igl.gov.common.utils;

import com.igl.gov.common.api.DataGridResult;
import com.igl.gov.common.api.DataListResult;
import com.igl.gov.common.api.DataResult;
import com.igl.gov.common.api.DatasResult;

/**
 * 前端返回结果响应工具
 *  fancr
 */
public class ResponseUtils {

    private ResponseUtils(){

    }

    public static DataResult success(DataResult result){
         if(result == null){
             result = new DataResult(true);
         }
        return result;
    }

    public static DatasResult success(DatasResult result){
        if(result == null){
            result = new DatasResult(true);
        }
        return result;
    }

    public static DataListResult success(DataListResult result){
        if(result == null){
            result = new DataListResult(true);
        }
        return result;
    }

    public static DataGridResult success(DataGridResult result){
        return result;
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
