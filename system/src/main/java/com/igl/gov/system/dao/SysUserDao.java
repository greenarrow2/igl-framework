package com.igl.gov.system.dao;

import com.igl.gov.system.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserDao {

    int insert(SysUser user);

}
