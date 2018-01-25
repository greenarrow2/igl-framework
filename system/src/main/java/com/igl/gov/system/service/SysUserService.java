package com.igl.gov.system.service;


import com.igl.gov.system.dto.SysUserDto;
import com.igl.gov.system.entity.SysUser;

public interface SysUserService{

    public SysUser add(SysUser user);

    public SysUserDto findUserByUserNamePassword(String userName,String password);

}