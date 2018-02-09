package com.igl.gov.system.dao;

import com.igl.gov.system.dto.SysRoleUserDto;
import com.igl.gov.system.entity.SysRoleUser;
import com.igl.gov.system.param.SysRoleUserParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SysRoleUserDao {

    List<SysRoleUserDto> query(SysRoleUserParam param);

    int count(SysRoleUserParam param);

    int insert(SysRoleUser roleUser);

    int delete(Map<String,Object> param);

    int countRoleUser(SysRoleUser roleUser);

    SysRoleUserDto find(Integer id);
}
