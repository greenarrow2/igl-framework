package com.igl.gov.system.service;


import com.igl.gov.common.api.DataGridResult;
import com.igl.gov.system.dto.SysUserDto;
import com.igl.gov.system.entity.SysUser;
import com.igl.gov.system.param.SysUserDetailParam;
import com.igl.gov.system.param.SysUserParam;

import java.util.Map;

public interface SysUserService {

    SysUser save(SysUserDetailParam user);

    Integer delete(String ids);

    Map<String, Object> findUserByUsernamePassword(String username, String password);

    DataGridResult<SysUserDto> queryPageList(SysUserParam param);

    /**
     * 查询用户详情
     *
     * @param id
     * @return
     */
    SysUserDto find(Integer id);

}