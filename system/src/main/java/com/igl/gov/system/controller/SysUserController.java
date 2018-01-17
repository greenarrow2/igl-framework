package com.igl.gov.system.controller;

import com.igl.gov.system.entity.SysUser;
import com.igl.gov.system.service.SysUserService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitManagementTemplate;
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

    RabbitMessagingTemplate rabbitManagementTemplate;

    @RequestMapping("/")
    public String index(){
        sysUserService.add(new SysUser());
        rabbitTemplate.convertAndSend("hello","你好");
        return "index";
    }

}
