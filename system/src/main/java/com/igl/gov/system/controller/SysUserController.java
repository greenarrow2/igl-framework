package com.igl.gov.system.controller;

import com.igl.gov.common.util.JacksonUtil;
import com.igl.gov.redis.cache.RedisCache;
import com.igl.gov.system.entity.SysUser;
import com.igl.gov.system.service.SysUserService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Autowired
    private RedisCache redisCache;

    RabbitMessagingTemplate rabbitManagementTemplate;

    @RequestMapping("/")
    public String index(){
        sysUserService.add(new SysUser());
        SysUser user =  new SysUser();
           user.setId(1);
           user.setName("你是谁");
        redisCache.putCache("user-" + user.getId(),user);
        String message = JacksonUtil.serializeObjectToJson(user);
        rabbitTemplate.convertAndSend("hello",message);
        return "index";
    }

}
