package com.igl.gov.system.param;

import com.igl.gov.common.param.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel(value = "SysModuleParam")
public class SysModuleParam extends PageParam {

    @ApiModelProperty(name = "pid",value = "父模块id",required = false,dataType = "string")
    private Integer pid;

    @ApiModelProperty(name = "url",value = "请求路径",required = false,dataType = "string")
    private String url;

    @ApiModelProperty(name = "moduleCode",value = "模块编码",required = false,dataType = "string")
    private String moduleCode;

    @ApiModelProperty(name = "moduleName",value = "模块名称",required = false,dataType = "string")
    private String moduleName;

    @ApiModelProperty(name = "moduleDesc",value = "模块描述",required = false,dataType = "string")
    private String moduleDesc;

    @ApiModelProperty(name = "moduleType",value = "模块类型",required = false,dataType = "string")
    private Integer moduleType;

    @ApiModelProperty(name = "state",value = "状态",required = false,dataType = "string")
    private Integer state;

}
