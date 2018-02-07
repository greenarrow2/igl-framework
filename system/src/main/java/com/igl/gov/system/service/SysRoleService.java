package com.igl.gov.system.service;

import com.igl.gov.common.api.DataGridResult;
import com.igl.gov.common.utils.ResultUtils;
import com.igl.gov.system.dto.SysRoleDto;
import com.igl.gov.system.entity.SysRole;

import javax.servlet.http.HttpServletRequest;

public interface SysRoleService {

    public SysRole save(SysRole role);


    public SysRoleDto find(Integer id);

    public DataGridResult queryPageList(HttpServletRequest request);

    public ResultUtils delete(String ids);

}
