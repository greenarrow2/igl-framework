package com.igl.gov.system.service;

import com.igl.gov.common.api.DataGridResult;
import com.igl.gov.system.dto.SysModuleDto;
import com.igl.gov.system.dto.SysModuleTreeDto;
import com.igl.gov.system.entity.SysModule;
import com.igl.gov.system.param.SysModuleParam;
import io.swagger.models.auth.In;

import java.util.List;

public interface SysModuleService {

    public DataGridResult<SysModuleDto> queryPageList(SysModuleParam param);

    public SysModule save(SysModule module);

    public int delete(String ids);

    public List<SysModuleTreeDto> queryModuleTree(Integer id);

    public List<SysModuleDto> queryModuleByPid(Integer pid);
}
