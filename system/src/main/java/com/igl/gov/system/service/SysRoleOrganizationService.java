package com.igl.gov.system.service;

import com.igl.gov.common.api.DataGridResult;
import com.igl.gov.system.dto.SysRoleOrganizationDto;
import com.igl.gov.system.entity.SysRoleOrganization;
import com.igl.gov.system.param.SysRoleOrganizationParam;

import java.util.List;

public interface SysRoleOrganizationService {

    public DataGridResult queryPageList(SysRoleOrganizationParam param);

    public SysRoleOrganization add(SysRoleOrganization roleOrganization);

    public List<SysRoleOrganization> addList(List<SysRoleOrganization> roleOrganizations);

    public SysRoleOrganizationDto find(Integer id);

    public int delete(String ids);

}
