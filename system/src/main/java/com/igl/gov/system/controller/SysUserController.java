package com.igl.gov.system.controller;

import com.igl.gov.system.entity.SysUser;
import com.igl.gov.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("/")
    public String index(){
        sysUserService.add(new SysUser());
        return "index";
    }

}
