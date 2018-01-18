package com.igl.gov.system.controller;

import com.igl.gov.common.util.JacksonUtil;
import com.igl.gov.system.entity.SysUser;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class HelloReceiver {

    @RabbitListener(queues = "hello")
    public void process(String hello) {

        System.out.println("Receiver  : " + ((SysUser)JacksonUtil.deserializeJsonToObject(hello,SysUser.class)).getName());
    }

}
