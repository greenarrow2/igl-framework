package com.igl.gov.system.param;

import com.igl.gov.common.param.PageParam;
import lombok.Data;

@Data
public class SysOrganizationParam extends PageParam {

    private String orgCode;

    private String orgName;

    private Integer orgType;

    private Integer state;

    private Integer pid;
}
