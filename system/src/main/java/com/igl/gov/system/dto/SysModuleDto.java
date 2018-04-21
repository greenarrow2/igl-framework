package com.igl.gov.system.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysModuleDto implements Serializable {

    private Integer id;

    private Integer pid;

    private String url;

    private String icon;

    private String moduleCode;

    private String moduleName;

    private String moduleDesc;

    private Integer moduleType;

    private String stateName;

    private String parentModuleName;

    private String moduleTypeName;

}
