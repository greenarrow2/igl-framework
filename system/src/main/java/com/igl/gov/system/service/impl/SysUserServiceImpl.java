package com.igl.gov.system.service.impl;

//import com.igl.gov.redis.cache.RedisCache;
import com.igl.gov.common.utils.EncryptUtils;
import com.igl.gov.redis.cache.RedisCache;
import com.igl.gov.system.dao.SysUserDao;
import com.igl.gov.system.dto.SysUserDto;
import com.igl.gov.system.entity.SysUser;
import com.igl.gov.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class SysUserServiceImpl implements SysUserService{

    @Autowired
    private SysUserDao sysUserDao;

    @Autowired
    private RedisCache redisCache;

    @Transactional
    public SysUser add(SysUser user) {
        sysUserDao.insert(user);
        user.setName("小明");
        return user;
    }

    @Override
    public Map<String,Object> findUserByUserNamePassword(String userName, String password) {
        Map<String,Object> result = new HashMap<>();
        Map<String ,String> param = new HashMap<>();
          param.put("userName",userName);
          param.put("password",password);
         SysUserDto userDto = sysUserDao.queryLoginUser(param);
         if(userDto != null){
            result.put("loginSysUser",userDto);
            if(redisCache.getCache("user-name:" + userName,String.class) != null){
                redisCache.deleteCache("user-name:" + userName);
            }
             String tokenCode = EncryptUtils.getRandomSH1String();
             redisCache.putCache("user-name:" + userName, tokenCode);
             result.put("tokenCode",tokenCode);
         }
         return result;
    }
}
