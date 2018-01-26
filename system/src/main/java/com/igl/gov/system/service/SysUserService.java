package com.igl.gov.system.service;


import com.igl.gov.system.dto.SysUserDto;
import com.igl.gov.system.entity.SysUser;

import java.util.Map;

public interface SysUserService{

    public SysUser add(SysUser user);

    public Map<String,Object> findUserByUserNamePassword(String userName, String password);

}