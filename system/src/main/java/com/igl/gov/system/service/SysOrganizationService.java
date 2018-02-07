package com.igl.gov.system.service;

import com.igl.gov.common.api.DataGridResult;
import com.igl.gov.common.api.DataResult;
import com.igl.gov.system.entity.SysOrganization;
import com.igl.gov.system.param.SysOrganizationParam;

public interface SysOrganizationService {

    /**
     * 分页查询组织
     * @param param
     * @return
     */
    DataGridResult queryPageList(SysOrganizationParam param);

    SysOrganization save(SysOrganization organization);

}
