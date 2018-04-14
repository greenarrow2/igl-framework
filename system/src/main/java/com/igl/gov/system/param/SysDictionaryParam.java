package com.igl.gov.system.param;

import com.igl.gov.common.param.PageParam;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "SysDictionaryParam")
public class SysDictionaryParam extends PageParam {

    private Integer dictCode;

    private Integer dictNo;

    private String dictName;

    private Integer moduleDictNo;

    private String[] createTime;

}
