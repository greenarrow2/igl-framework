package com.igl.gov.system.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysRoleModuleDto implements Serializable {

    private Integer id;

    private Integer roleId;

    private String roleName;

    private Integer moduleId;

    private String url;

    private String icon;

    private String moduleName;

    private String moduleCode;

    private String moduleDesc;

    private String roleTypeName;

    private String moduleTypeName;

}
