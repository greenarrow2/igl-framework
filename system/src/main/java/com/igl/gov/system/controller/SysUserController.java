package com.igl.gov.system.controller;


import com.igl.gov.common.api.DataGridResult;
import com.igl.gov.common.api.DataResult;
import com.igl.gov.system.dto.SysUserDto;
import com.igl.gov.system.param.SysUserDetailParam;
import com.igl.gov.system.param.SysUserParam;
import com.igl.gov.system.service.SysUserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sysuser/")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @ApiOperation("用户查询")
    @RequestMapping(value = "pagelist",method = RequestMethod.POST)
    public DataGridResult pageList(SysUserParam param){
        return  sysUserService.queryPageList(param);
    }


    /**
     * 保存用户
     * @param user
     * @return
     */
    @ApiOperation("保存用户")
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public DataResult save(@RequestBody SysUserDetailParam user){
        return  new DataResult(sysUserService.save(user));
    }

    @ApiOperation("删除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids",value = "id字符串如：1,2,3",dataType = "string",paramType = "query",required = true)
    })
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public DataResult delete(String ids){
         Integer count = sysUserService.delete(ids);
          return new DataResult(true,null,"你删除了" + count + "条记录！");
    }

    @ApiOperation("显示单个")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "id",dataType = "Integer",paramType = "query",required = true)
    })
    @RequestMapping(value = "/find",method = RequestMethod.POST)
    public SysUserDto find(Integer id){
      return  sysUserService.find(id);
    }
}
