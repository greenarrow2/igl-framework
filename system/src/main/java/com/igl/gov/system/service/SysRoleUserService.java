package com.igl.gov.system.service;

import com.igl.gov.common.api.DataGridResult;
import com.igl.gov.system.dto.SysRoleUserDto;
import com.igl.gov.system.entity.SysRoleUser;
import com.igl.gov.system.param.SysRoleUserParam;

public interface SysRoleUserService {

    public DataGridResult queryPageList(SysRoleUserParam param);

    public SysRoleUser add(SysRoleUser roleUser);

    public SysRoleUserDto find(Integer id);

    public int delete(String ids);

}
