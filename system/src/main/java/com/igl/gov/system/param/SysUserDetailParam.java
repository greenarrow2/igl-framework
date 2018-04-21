package com.igl.gov.system.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by wangjiguang on 2018/4/21.
 * desc :
 */
@Data
public class SysUserDetailParam {


    @ApiModelProperty(name = "id",value = "id",required = false,dataType = "Integer")
    private Integer id;

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

    @ApiModelProperty(name = "roleId",value = "角色id",required = false,dataType = "integer")
    private Integer roleId;

    @ApiModelProperty(name = "orgId",value = "组织id",required = false,dataType = "integer")
    private Integer orgId;


}
