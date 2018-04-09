package com.igl.gov.system.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SysRole implements Serializable {

    private Integer id;

    private Integer pid;

    private Integer roleType;

    private String roleName;

    private Integer state;

    private Integer createBy;

    private Integer updateBy;

}
