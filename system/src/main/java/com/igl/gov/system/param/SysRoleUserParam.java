package com.igl.gov.system.param;

import com.igl.gov.common.param.PageParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("SysRoleUserParam")
public class SysRoleUserParam extends PageParam{

    /*@ApiModelProperty(value = "roleId",name = "角色id",required = false,dataType = "integer")
    private Integer roleId;*/

    @ApiModelProperty(name = "roleType",value = "角色类型",required = false,dataType = "integer")
    private Integer roleType;

    @ApiModelProperty(name = "roleName",value = "角色名称",required = false,dataType = "integer")
    private String roleName;

    @ApiModelProperty(name = "username",value = "用户名称",required = false,dataType = "integer")
    private String username;

}
