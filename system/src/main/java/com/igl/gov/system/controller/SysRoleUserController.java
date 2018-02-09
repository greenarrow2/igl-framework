package com.igl.gov.system.controller;

import com.igl.gov.common.api.DataGridResult;
import com.igl.gov.common.api.DataResult;
import com.igl.gov.system.dto.SysRoleUserDto;
import com.igl.gov.system.entity.SysRoleUser;
import com.igl.gov.system.param.SysRoleUserParam;
import com.igl.gov.system.service.SysRoleUserService;
import com.sun.javafx.binding.StringFormatter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;

@Api(tags = "角色用户")
@RestController
@RequestMapping("/api/sysroleuser/")
public class SysRoleUserController {

    @Autowired
    private SysRoleUserService sysRoleUserService;

    @ApiOperation("角色用户分页查找")
    @RequestMapping(value = "pagelist",method = RequestMethod.POST)
    public DataGridResult pageList(SysRoleUserParam param){
        return sysRoleUserService.queryPageList(param);
    }

    @ApiOperation("删除")
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public DataResult delete(String ids){
        return new DataResult(true, MessageFormat.format("删除了{0}条数据",sysRoleUserService.delete(ids)));
    }

    @ApiOperation("删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleId",value = "角色id",dataType = "integer",paramType = "form",required = true),
            @ApiImplicitParam(name = "userId",value = "用户id",dataType = "integer",paramType = "form",required = true)
    })
    @RequestMapping(value = "bind",method = RequestMethod.POST)
    public DataResult bind(SysRoleUser roleUser){
        return new DataResult(true, sysRoleUserService.add(roleUser) ,"绑定数据成功！");
    }

    @ApiOperation("获取单条数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "ID",dataType = "integer",paramType = "query",required = true),
    })
    @RequestMapping(value = "find",method = RequestMethod.POST)
    public SysRoleUserDto find(Integer id){
        return  sysRoleUserService.find(id);
    }
}
