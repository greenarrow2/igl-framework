package com.igl.gov.system.param;

import com.igl.gov.common.param.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "SysUserParam")
public class SysUserParam extends PageParam {

    @ApiModelProperty(name = "username",value = "用户名称",required = false,dataType = "string")
    private String username;

    @ApiModelProperty(name = "name",value = "姓名",required = false,dataType = "string")
    private String name;

    @ApiModelProperty(name = "email",value = "邮件",required = false,dataType = "string")
    private String email;

    @ApiModelProperty(name = "mobile",value = "手机号",required = false,dataType = "string")
    private String mobile;

    @ApiModelProperty(name = "gender",value = "性别",required = false,dataType = "integer")
    private Integer gender;

}
