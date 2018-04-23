package com.igl.gov.system.dao;

import com.igl.gov.system.dto.SysModuleDto;
import com.igl.gov.system.dto.SysModuleTreeDto;
import com.igl.gov.system.entity.SysModule;
import com.igl.gov.system.param.SysModuleParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SysModuleDao {

   List<SysModuleDto> query(SysModuleParam param);

    List<SysModuleDto> queryModuleByPid(Integer pid);

   int count(SysModuleParam param);

    int insert(SysModule module);

    int update(SysModule module);

    SysModuleDto find(Integer id);

    int countByModuleCode(Map<String,Object> param);

    int countChildren(Map<String,Object> param);

    int delete(Map<String,Object> param);

    List<SysModuleTreeDto> queryModuleList(Map<String,Object> param);
}
