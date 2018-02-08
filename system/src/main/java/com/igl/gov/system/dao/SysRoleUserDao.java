package com.igl.gov.system.dao;

import com.igl.gov.system.dto.SysRoleUserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysRoleUserDao {
    List<SysRoleUserDto> query();
}
