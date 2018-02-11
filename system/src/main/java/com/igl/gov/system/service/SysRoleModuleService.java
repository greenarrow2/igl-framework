package com.igl.gov.system.service;

import com.igl.gov.common.api.DataGridResult;
import com.igl.gov.system.dto.SysRoleModuleDto;
import com.igl.gov.system.dto.SysRoleModuleTreeDto;
import com.igl.gov.system.entity.SysRoleModule;
import com.igl.gov.system.param.SysRoleModuleParam;

import java.util.List;

public interface SysRoleModuleService {

    public DataGridResult queryPageList(SysRoleModuleParam param);

    public SysRoleModule add(SysRoleModule roleModule);

    public List<SysRoleModule> addList(List<SysRoleModule> sysRoleModules);

    public SysRoleModuleDto find(Integer id);

    public int delete(String ids);

    public List<SysRoleModuleTreeDto> queryRoleModuleByRoleId(String [] roleIds);

    public List<SysRoleModuleTreeDto> queryRoleModuleByRoleIdAndPid(String [] roleIds,Integer pid);

}
