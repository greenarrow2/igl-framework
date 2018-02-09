package com.igl.gov.system.param;

import com.igl.gov.common.param.PageParam;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel("SysRoleOrganizationParam")
public class SysRoleOrganizationParam extends PageParam {

    private String orgName;

    private String roleName;

    private Integer orgType;

    private Integer roleType;

}
