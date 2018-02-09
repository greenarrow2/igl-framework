package com.igl.gov.system.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysRoleUserDto implements Serializable {

    private Integer id;

    private Integer roleId;

    private Integer userId;

    private String roleName;

    private String userName;

    private String roleTypeName;

}
