package com.igl.gov.system.dao;

import com.igl.gov.system.dto.SysRoleDto;
import com.igl.gov.system.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Map;

@Mapper
public interface SysRoleDao {

    int insert(SysRole role);

    int update(SysRole role);

    int delete(Map<String,Object> param);

    List<SysRoleDto> query(Map<String,Object> param);

    int count(Map<String,Object> param);

    SysRoleDto find(Integer id);

}
