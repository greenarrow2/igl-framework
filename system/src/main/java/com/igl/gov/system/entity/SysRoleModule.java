package com.igl.gov.system.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysRoleModule implements Serializable{

    private Integer id;

    private Integer roleId;

    private Integer moduleId;

    private Integer createBy;

}