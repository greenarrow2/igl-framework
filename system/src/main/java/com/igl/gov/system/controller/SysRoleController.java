package com.igl.gov.system.controller;

import com.igl.gov.common.api.DataGridResult;
import com.igl.gov.common.api.DataResult;
import com.igl.gov.common.utils.ResultUtils;
import com.igl.gov.system.dto.SysRoleDto;
import com.igl.gov.system.entity.SysRole;
import com.igl.gov.system.service.SysRoleService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Api(value = "角色操作类",tags = "角色",description = "角色增删该查的基础操作")
@RestController
@RequestMapping("/sysrole/")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @ApiOperation(value = "角色分页查询",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleName",value = "角色名称",required = false,dataType = "string"),
            @ApiImplicitParam(name = "page",value = "页面参数",required = true,dataType = "integer"),
            @ApiImplicitParam(name = "rows",value = "分页大小",required = true,dataType = "integer")
    })
    @RequestMapping(value = "pagelist",method = RequestMethod.POST)
    @ResponseBody
    public DataGridResult<SysRoleDto> pageList(HttpServletRequest request){
        return sysRoleService.queryPageList(request);
    }

    @ApiOperation(value = "保存角色",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name ="pid",value = "父角色id",dataType = "integer",required = false),
            @ApiImplicitParam(name = "roleName",value = "角色名称",dataType = "string",required = true),
            @ApiImplicitParam(name = "roleType",value = "角色类型",dataType = "string",required = true),
            @ApiImplicitParam(name = "state",value = "状态",dataType = "integer",required = true)
    })
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public DataResult save(@ModelAttribute("role") SysRole role){
        return new DataResult(true,sysRoleService.save(role));
    }

    @ApiOperation(value = "删除角色",httpMethod = "DELETE")
    @ApiImplicitParams({
            @ApiImplicitParam(name ="ids",value = "id字符串‘1，2，3，4’",dataType = "string",required = true),
    })
    @RequestMapping(value = "delete",method = RequestMethod.DELETE)
    public DataResult delete(String ids){
        ResultUtils result = sysRoleService.delete(ids);
        return new DataResult(result.isSuccess(),result.getMessage());
    }

}
