package com.igl.gov.system.controller;

import com.igl.gov.common.api.DataResult;
import com.igl.gov.common.utils.EncryptUtils;
import com.igl.gov.redis.cache.RedisCache;
import com.igl.gov.shrio.custom.HmacSHA256Utils;
import com.igl.gov.shrio.custom.StatelessAuthenticationToken;
import com.igl.gov.system.dto.SysUserDto;
import com.igl.gov.system.entity.SysUser;
import com.igl.gov.system.service.SysUserService;
import com.sun.security.auth.UserPrincipal;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

//import com.igl.gov.redis.cache.RedisCache;
//import org.springframework.amqp.core.AmqpTemplate;
//import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;



@RestController
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private RedisCache redisCache;

    @RequestMapping("/login")
    public DataResult login(String userName, String password){
        DataResult result = new DataResult();
        Map<String,Object> map = sysUserService.findUserByUserNamePassword(userName, password);
           if(map.size() == 2){
               result.setSuccess(true);
               result.setObj(map);
               return result;
           }
           result = new DataResult(false,null);
           return result;
    }

}
