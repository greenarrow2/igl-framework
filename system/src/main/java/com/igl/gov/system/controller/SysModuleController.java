package com.igl.gov.system.controller;

import com.igl.gov.common.api.DataGridResult;
import com.igl.gov.common.utils.ResponseUtils;
import com.igl.gov.system.dto.SysModuleTreeDto;
import com.igl.gov.system.param.SysModuleParam;
import com.igl.gov.system.service.SysModuleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sysmodule/")
public class SysModuleController {

    @Autowired
    private SysModuleService sysModuleService;

    @ApiOperation("分页查询")
    @RequestMapping(value = "pagelist",method = RequestMethod.POST)
    public DataGridResult pageList(SysModuleParam param){
        return  sysModuleService.queryPageList(param);
    }

    @ApiOperation(notes = "查询菜单树",value = "传入参数为null时查询所有的菜单；id不为null时，查询该菜单包括所有子菜单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "菜单id",dataType = "integer",paramType = "query",required = false)
    })
    @RequestMapping(value = "tree",method = RequestMethod.POST)
    public List<SysModuleTreeDto> tree(Integer id){
         return sysModuleService.queryModuleTree(id);
    }
}
