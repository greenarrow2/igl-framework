package com.igl.gov.system.dao;

import com.igl.gov.system.dto.SysUserDto;
import com.igl.gov.system.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SysUserDao {

    int insert(SysUser user);

    SysUserDto queryLoginUser(Map<String,String> param);

    int update(SysUser user);

    List<SysUserDto> query(Map<String,Object> param);

    Integer count(Map<String,Object> param);

    int delete(Map<String,Object> param);
}
