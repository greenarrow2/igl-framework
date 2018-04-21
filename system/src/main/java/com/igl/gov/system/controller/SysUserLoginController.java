package com.igl.gov.system.controller;

import com.igl.gov.common.api.DataResult;
import com.igl.gov.redis.cache.RedisCache;
import com.igl.gov.system.param.SysUserDetailParam;
import com.igl.gov.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

//import com.igl.gov.redis.cache.RedisCache;
//import org.springframework.amqp.core.AmqpTemplate;
//import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;


@RestController
public class SysUserLoginController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private RedisCache redisCache;

    @RequestMapping("/login")
    public DataResult login(String username, String password){
        DataResult result = new DataResult();
        Map<String,Object> map = sysUserService.findUserByUsernamePassword(username, password);
           if(map.size() == 2){
               result.setSuccess(true);
               result.setObj(map);
               return result;
           }
           result = new DataResult(false,map);
           return result;
    }

    @RequestMapping("/register")
    public DataResult register(SysUserDetailParam user){
        sysUserService.save(user);
        return new DataResult(true,user);
    }

    @RequestMapping("/logout")
    public DataResult logout(String username){
        DataResult result = new DataResult();
        redisCache.deleteCache("user-name:" + username);
        result = new DataResult(false,result);
        return result;
    }


}
