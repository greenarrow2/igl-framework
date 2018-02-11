package com.igl.gov.system.param;

import com.igl.gov.common.param.PageParam;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel("SysRoleModuleParam")
public class SysRoleModuleParam extends PageParam{

    private String moduleName;

    private String roleName;

    private String moduleCode;

    private Integer roleType;

    private Integer moduleType;

}
