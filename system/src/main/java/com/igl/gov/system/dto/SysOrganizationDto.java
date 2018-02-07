package com.igl.gov.system.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysOrganizationDto implements Serializable {

    private Integer id;

    private String orgCode;

    private String orgName;

    private Integer orgType;

    private Integer state;

    private Integer createBy;

    private Integer updateBy;

    private Integer pid;

}
