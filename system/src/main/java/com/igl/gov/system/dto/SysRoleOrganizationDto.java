package com.igl.gov.system.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysRoleOrganizationDto implements Serializable {

    private Integer id;

    private Integer roleId;

    private Integer orgId;

    private String roleName;

    private String orgName;

    private String roleTypeName;

    private String orgTypeName;

    private String orgCode;
}
