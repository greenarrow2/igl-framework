package com.igl.gov.system.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysModule implements Serializable {

    private Integer id;

    private Integer pid;

    private String url;

    private String icon;

    private String moduleCode;

    private String moduleName;

    private String moduleDesc;

    private Integer moduleType;

    private Integer state;

    private Integer createBy;

    private Integer updateBy;

}
