package com.igl.gov.system.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysRoleOrganization implements Serializable {

    private Integer id;

    private Integer roleId;

    private Integer orgId;

    private Integer createBy;
}
