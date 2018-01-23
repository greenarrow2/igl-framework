package com.igl.gov.system.controller;

import com.igl.gov.system.service.SysUserService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.igl.gov.redis.cache.RedisCache;
//import org.springframework.amqp.core.AmqpTemplate;
//import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;



@RestController
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

//    @Autowired
//    private AmqpTemplate rabbitTemplate;

//    @Autowired
//    private RedisCache redisCache;
//
//    RabbitMessagingTemplate rabbitManagementTemplate;

    @RequestMapping("/hello")
    @RequiresRoles("admin")
    public String index(HttpServletRequest request){
      /*  sysUserService.add(new SysUser());
        SysUser user =  new SysUser();*/
         /* user.setId(1);
           user.setName("你是谁");
        redisCache.putCache("user-" + user.getId(),user);
        String message = JacksonUtils.serializeObjectToJson(user);
        rabbitTemplate.convertAndSend("hello",message);*/
      /*  Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        System.out.println(session);*/
        return "hello3,Andy";
        //return "index";
    }

}
