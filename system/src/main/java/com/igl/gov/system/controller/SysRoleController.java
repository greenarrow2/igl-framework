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

@Api(tags = "角色")
@RestController
@RequestMapping("/api/sysrole/")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @ApiOperation(value = "角色分页查询",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleName",value = "角色名称",required = false,paramType = "query",dataType = "string"),
            @ApiImplicitParam(name = "page",value = "页面参数",required = true,paramType = "query",dataType = "integer"),
            @ApiImplicitParam(name = "rows",value = "分页大小",required = true,paramType = "query",dataType = "integer")
    })
    @RequestMapping(value = "pagelist",method = RequestMethod.POST)
    @ResponseBody
    public DataGridResult<SysRoleDto> pageList(HttpServletRequest request){
        return sysRoleService.queryPageList(request);
    }

    @ApiOperation(value = "保存角色",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name ="pid",value = "父角色id",dataType = "integer",paramType = "form",required = false),
            @ApiImplicitParam(name = "roleName",value = "角色名称",dataType = "string",paramType = "form",required = true),
            @ApiImplicitParam(name = "roleType",value = "角色类型",dataType = "string",paramType = "form",required = true),
            @ApiImplicitParam(name = "state",value = "状态",dataType = "integer",paramType = "form",required = true)
    })
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public DataResult save(@ModelAttribute("role") SysRole role){
        return new DataResult(true,sysRoleService.save(role));
    }

    @ApiOperation(value = "删除角色")
    @ApiImplicitParams({
            @ApiImplicitParam(name ="ids",value = "id字符串‘1，2，3，4’",dataType = "string",paramType = "query",required = true),
    })
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public DataResult delete(String ids){
        ResultUtils result = sysRoleService.delete(ids);
        return new DataResult(result.isSuccess(),result.getMessage());
    }

}
