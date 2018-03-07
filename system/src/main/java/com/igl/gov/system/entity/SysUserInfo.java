package com.igl.gov.system.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysUserInfo implements Serializable {

    private Integer id;

    private Integer userId;

    private Integer gender;

    private Integer roleId;

    private Integer createBy;

    private Integer updateBy;

}
