package com.igl.gov.system.controller;

import com.igl.gov.common.api.DataGridResult;
import com.igl.gov.common.api.DataResult;
import com.igl.gov.common.utils.ResponseUtils;
import com.igl.gov.system.dto.SysOrganizationDto;
import com.igl.gov.system.entity.SysOrganization;
import com.igl.gov.system.param.SysOrganizationParam;
import com.igl.gov.system.service.SysOrganizationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@Api(tags = "组织",value = "组织操作增删改查")
@RestController
@RequestMapping("/api/sysorg/")
public class SysOrganizationController {

    @Autowired
    private SysOrganizationService sysOrganizationService;

    @ApiOperation(value = "组织分页查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orgCode",value = "组织编号",dataType = "string"),
            @ApiImplicitParam(name = "orgType",value = "组织类型",dataType = "integer"),
            @ApiImplicitParam(name = "orgName",value = "组织名称",dataType = "string"),
            @ApiImplicitParam(name = "state",value = "状态",dataType = "Integer"),
    })
    @RequestMapping(value = "pagelist",method = RequestMethod.POST)
    public DataGridResult<SysOrganizationDto> pageList(SysOrganizationParam param){
        return sysOrganizationService.queryPageList(param);
    }

    @ApiOperation(value = "组织保存")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orgCode",value = "组织编号",dataType = "string",required = true),
            @ApiImplicitParam(name = "orgType",value = "组织类型",dataType = "integer",required = true),
            @ApiImplicitParam(name = "orgName",value = "组织名称",dataType = "string",required = true),
            @ApiImplicitParam(name = "state",value = "状态",dataType = "Integer",required = true),
            @ApiImplicitParam(name = "pid",value = "父组织",dataType = "integer",required = false)
    })
    @RequestMapping(value = "save",method = RequestMethod.POST)
    @ResponseBody
    public DataResult save(SysOrganization organization){
          return new DataResult(true,sysOrganizationService.save(organization));
    }

}
