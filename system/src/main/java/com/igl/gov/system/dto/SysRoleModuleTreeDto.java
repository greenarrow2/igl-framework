package com.igl.gov.system.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SysRoleModuleTreeDto {

    private Integer roleId;

    private String roleName;

    private Integer moduleId;

    private String url;

    private String icon;

    private String moduleCode;

    private String moduleName;

    private Integer moduleType;

    private String moduleDesc;

    List<SysRoleModuleTreeDto> roleModuleTrees = new ArrayList<>();

}
