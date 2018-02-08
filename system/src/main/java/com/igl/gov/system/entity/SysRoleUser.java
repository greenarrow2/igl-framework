package com.igl.gov.system.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysRoleUser implements Serializable {

    private Integer id;

    private Integer roleId;

    private Integer userId;

    private Integer createBy;

}
