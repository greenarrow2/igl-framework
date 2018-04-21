package com.igl.gov.system.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
public class SysOrganizationDto implements Serializable {

    private Integer id;

    private String orgCode;

    private String orgName;

    private Integer orgType;

    private String orgTypeName;

    private String stateName;

    private Integer createBy;

    private Integer updateBy;

    private Integer pid;

    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

}
