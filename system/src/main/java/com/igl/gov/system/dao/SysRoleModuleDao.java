package com.igl.gov.system.dao;

import com.igl.gov.system.dto.SysRoleModuleDto;
import com.igl.gov.system.dto.SysRoleModuleTreeDto;
import com.igl.gov.system.entity.SysRoleModule;
import com.igl.gov.system.param.SysRoleModuleParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SysRoleModuleDao {

    List<SysRoleModuleDto> query(SysRoleModuleParam param);

    int count(SysRoleModuleParam param);

    int insert(SysRoleModule roleModule);

    int delete(Map<String, Object> param);

    SysRoleModuleDto find(Integer id);

    int countRoleModule(SysRoleModule roleModule);

    List<SysRoleModuleTreeDto> queryRoleModuleByRoleIdAndModuleId(Map<String,Object> param);
}
