package com.igl.gov.system.service;

import com.igl.gov.common.api.DataGridResult;
import com.igl.gov.system.dto.SysRoleOrganizationDto;
import com.igl.gov.system.entity.SysRoleOrganization;
import com.igl.gov.system.param.SysRoleOrganizationParam;

public interface SysRoleOrganizationService {

    public DataGridResult queryPageList(SysRoleOrganizationParam param);

    public SysRoleOrganization add(SysRoleOrganization roleUser);

    public SysRoleOrganizationDto find(Integer id);

    public int delete(String ids);

}
