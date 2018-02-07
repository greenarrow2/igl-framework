package com.igl.gov.system.service;


import com.igl.gov.common.api.DataGridResult;
import com.igl.gov.system.dto.SysUserDto;
import com.igl.gov.system.entity.SysUser;
import com.igl.gov.system.entity.SysUserInfo;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface SysUserService{

    public SysUser save(SysUser user, SysUserInfo userInfo);

    public Integer delete(String ids);

    public Map<String,Object> findUserByUsernamePassword(String username, String password);

    public DataGridResult<SysUserDto> queryPageList(HttpServletRequest request);

    /**
     * 查询用户详情
     * @param id
     * @return
     */
    public SysUserDto find(Integer id);

}