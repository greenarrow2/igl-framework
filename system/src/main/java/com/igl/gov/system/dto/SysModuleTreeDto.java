package com.igl.gov.system.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class SysModuleTreeDto implements Serializable {

    private Integer id;

    private Integer pid;

    private String url;

    private String icon;

    private String moduleCode;

    private String moduleName;

    private String moduleDesc;

    private Integer moduleType;

    private Integer state;

    private List<SysModuleTreeDto> moduleTree = new ArrayList<>();
}
