package com.igl.gov.system.service.impl;


import com.igl.gov.common.api.DataGridResult;
import com.igl.gov.common.utils.EncryptUtils;
import com.igl.gov.common.utils.StringUtils;
import com.igl.gov.redis.cache.RedisCache;
import com.igl.gov.system.dao.SysUserDao;
import com.igl.gov.system.dao.SysUserInfoDao;
import com.igl.gov.system.dto.SysUserDto;
import com.igl.gov.system.entity.SysUser;
import com.igl.gov.system.entity.SysUserInfo;
import com.igl.gov.system.param.SysUserParam;
import com.igl.gov.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysUserServiceImpl implements SysUserService{

    @Autowired
    private SysUserDao sysUserDao;

    @Autowired
    private SysUserInfoDao sysUserInfoDao;

    @Autowired
    private RedisCache redisCache;

    @Transactional
    public SysUser save(SysUser user,SysUserInfo userInfo) {
        if(user.getId() != null){
            sysUserDao.insert(user);
            userInfo.setUserId(user.getId());
            userInfo.setCreateBy(user.getCreateBy());
            sysUserInfoDao.insert(userInfo);
        }else {
            sysUserDao.update(user);
            userInfo.setUserId(user.getId());
            userInfo.setUpdateBy(user.getUpdateBy());
            sysUserInfoDao.update(userInfo);
        }
        return user;
    }

    @Override
    public Integer delete(String ids) {
        if(!StringUtils.isEmpty(ids)){
          String [] idarr =  ids.split(",");
          Map<String,Object> param = new HashMap<>(1);
             param.put("ids",idarr);
         return sysUserDao.delete(param);
        }
        return 0;
    }

    @Override
    public Map<String,Object> findUserByUsernamePassword(String username, String password) {
        Map<String,Object> result = new HashMap<>();
        Map<String ,String> param = new HashMap<>();
          param.put("username",username);
          param.put("password",password);
         SysUserDto userDto = sysUserDao.queryLoginUser(param);
         if(userDto != null){
            result.put("loginSysUser",userDto);
            if(redisCache.getCache("user-name:" + username,String.class) != null){
                redisCache.deleteCache("user-name:" + username);
            }
             String tokenCode = EncryptUtils.getRandomSH1String();
             redisCache.putCache("user-name:" + username, tokenCode);
             result.put("tokenCode",tokenCode);
         }
         return result;
    }

    @Override
    public DataGridResult<SysUserDto> queryPageList(SysUserParam param){
        List<SysUserDto> items = sysUserDao.query(param);
        int countNums = sysUserDao.count(param);            //总记录数
        return new DataGridResult<SysUserDto>(param,countNums,items);
    }

    @Override
    public SysUserDto find(Integer id) {
        return sysUserDao.find(id);
    }
}
