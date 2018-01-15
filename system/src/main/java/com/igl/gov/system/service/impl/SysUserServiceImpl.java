package com.igl.gov.system.service.impl;

import com.igl.gov.redis.dao.RedisDao;
import com.igl.gov.system.dao.SysUserDao;
import com.igl.gov.system.entity.SysUser;
import com.igl.gov.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SysUserServiceImpl implements SysUserService{

    @Autowired
    private SysUserDao sysUserDao;

    @Autowired
    private RedisDao redisDao;

    @Transactional
    public SysUser add(SysUser user) {
        sysUserDao.insert(user);
        user.setName("小明");
        redisDao.putCache("1",user);
        return user;
    }
}
