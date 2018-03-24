package com.igl.gov.system.controller;

import com.igl.gov.common.api.DataGridResult;
import com.igl.gov.common.api.DataResult;
import com.igl.gov.common.exception.IglException;
import com.igl.gov.common.utils.JacksonUtils;
import com.igl.gov.common.utils.StringUtils;
import com.igl.gov.system.dto.SysRoleModuleDto;
import com.igl.gov.system.dto.SysRoleModuleTreeDto;
import com.igl.gov.system.entity.SysRoleModule;
import com.igl.gov.system.param.SysRoleModuleParam;
import com.igl.gov.system.service.SysRoleModuleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.text.MessageFormat;
import java.util.List;

@RestController
@RequestMapping("/api/sysrolemodule/")
public class SysRoleModuleController {

    @Autowired
    private SysRoleModuleService sysRoleModuleService;

    @ApiOperation("角色模块分页查找")
    @RequestMapping(value = "pagelist",method = RequestMethod.POST)
    public DataGridResult pageList(SysRoleModuleParam param){
        return sysRoleModuleService.queryPageList(param);
    }

    @ApiOperation("删除")
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public DataResult delete(String ids){
        return new DataResult(true, MessageFormat.format("删除了{0}条数据",sysRoleModuleService.delete(ids)));
    }

    @ApiOperation("绑定")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleId",value = "角色id",dataType = "integer",paramType = "form",required = true),
            @ApiImplicitParam(name = "moduleId",value = "模块id",dataType = "integer",paramType = "form",required = true)
    })
    @RequestMapping(value = "bind",method = RequestMethod.POST)
    public DataResult bind(SysRoleModule roleModule){
        return new DataResult(true, sysRoleModuleService.add(roleModule) ,"绑定数据成功！");
    }

    @ApiOperation("批量绑定")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleModules",value = "角色id模块id json字符串",dataType = "string",paramType = "form",required = true)
    })
    @RequestMapping(value = "bindlist",method = RequestMethod.POST)
    public DataResult bindList(String roleModules){
        List<SysRoleModule> roleModuleList = JacksonUtils.deserializeJsonToList(roleModules,SysRoleModule.class);
        sysRoleModuleService.addList(roleModuleList);
        return new DataResult(true,  null ,MessageFormat.format("绑定{0}条数据成功！",roleModuleList.size()));
    }

    @ApiOperation("获取单条数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "ID",dataType = "integer",paramType = "query",required = true),
    })
    @RequestMapping(value = "find",method = RequestMethod.POST)
    public SysRoleModuleDto find(Integer id){
        return  sysRoleModuleService.find(id);
    }

    @ApiOperation("根据角色获取权限列表(全部角色权限模块)")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleIds",value = "角色字符串，多个角色（1，2）",dataType = "integer",paramType = "query",required = true),
    })
    @RequestMapping(value = "queryrolemodulebyroleid",method = RequestMethod.POST)
    public List<SysRoleModuleTreeDto> queryRoleModuleByRoleId(String roleIds){
             if(StringUtils.isEmpty(roleIds)){
                 throw new IglException("参数传递异常！");
             }
             String [] ids = roleIds.split(",");
         return sysRoleModuleService.queryRoleModuleByRoleId(ids);
    }

    @ApiOperation("根据角色获取权限列表（分步获取）")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleIds",value = "角色字符串，多个角色（1，2）",dataType = "integer",paramType = "query",required = true),
            @ApiImplicitParam(name = "pid",value = "模块父id",dataType = "integer",paramType = "query",required = false),
    })
    @RequestMapping(value = "queryrolemodulebyroleidandpid",method = RequestMethod.POST)
    public List<SysRoleModuleTreeDto> queryRoleModuleByRoleIdAndPid(String roleIds,Integer pid){
        if(StringUtils.isEmpty(roleIds)){
            throw new IglException("参数传递异常！");
        }
        String [] ids = roleIds.split(",");
        return sysRoleModuleService.queryRoleModuleByRoleIdAndPid(ids,pid);
    }
}
