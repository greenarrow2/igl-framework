package com.igl.gov.system.controller;

import com.igl.gov.common.utils.JacksonUtils;
import com.igl.gov.system.entity.SysUser;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SysIndexController {


     @RequestMapping(value = "/main",method = RequestMethod.GET)
     public String main(){
         return "index";
     }

}
