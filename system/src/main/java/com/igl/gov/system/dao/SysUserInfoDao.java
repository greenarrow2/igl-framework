package com.igl.gov.system.dao;

import com.igl.gov.system.entity.SysUserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserInfoDao {

    int insert(SysUserInfo user);


    int update(SysUserInfo user);
}
