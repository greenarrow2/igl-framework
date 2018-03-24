package com.igl.gov.system.controller;

import com.igl.gov.common.api.DataGridResult;
import com.igl.gov.common.api.DataResult;
import com.igl.gov.common.utils.JacksonUtils;
import com.igl.gov.system.dto.SysRoleOrganizationDto;
import com.igl.gov.system.entity.SysRoleOrganization;
import com.igl.gov.system.param.SysRoleOrganizationParam;
import com.igl.gov.system.service.SysRoleOrganizationService;
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
@RequestMapping(value = "/api/sysroleorganization/")
public class SysRoleOrganizationController {

    @Autowired
    private SysRoleOrganizationService sysRoleOrganizationService;

    @ApiOperation("角色组织分页查找")
    @RequestMapping(value = "pagelist", method = RequestMethod.POST)
    public DataGridResult pageList(SysRoleOrganizationParam param) {
        return sysRoleOrganizationService.queryPageList(param);
    }

    @ApiOperation("删除")
    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public DataResult delete(String ids) {
        return new DataResult(true, MessageFormat.format("删除了{0}条数据", sysRoleOrganizationService.delete(ids)));
    }

    @ApiOperation("绑定")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleId", value = "角色id", dataType = "integer", paramType = "form", required = true),
            @ApiImplicitParam(name = "orgId", value = "组织id", dataType = "integer", paramType = "form", required = true)
    })
    @RequestMapping(value = "bind", method = RequestMethod.POST)
    public DataResult bind(SysRoleOrganization roleOrganization) {
        return new DataResult(true, sysRoleOrganizationService.add(roleOrganization), "绑定数据成功！");
    }

    @ApiOperation("绑定")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleOrgs", value = "角色id组织id json字符串", dataType = "string", paramType = "form", required = true)
    })
    @RequestMapping(value = "bindlist", method = RequestMethod.POST)
    public DataResult bindList(String roleOrgs) {
        List<SysRoleOrganization> roleOrganizationList = JacksonUtils.deserializeJsonToList(roleOrgs, SysRoleOrganization.class);
        sysRoleOrganizationService.addList(roleOrganizationList);
        return new DataResult(true, null, MessageFormat.format("绑定{0}条数据成功！", roleOrganizationList.size()));
    }

    @ApiOperation("获取单条数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "ID", dataType = "integer", paramType = "query", required = true),
    })
    @RequestMapping(value = "find", method = RequestMethod.POST)
    public SysRoleOrganizationDto find(Integer id) {
        return sysRoleOrganizationService.find(id);
    }
}
