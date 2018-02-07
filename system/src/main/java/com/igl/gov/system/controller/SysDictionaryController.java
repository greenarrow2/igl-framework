package com.igl.gov.system.controller;

import com.igl.gov.common.api.DataResult;
import com.igl.gov.system.dto.SysDictSimpleDto;
import com.igl.gov.system.dto.SysDictionaryDto;
import com.igl.gov.system.entity.SysDictionary;
import com.igl.gov.system.service.SysDictionaryService;
import io.swagger.annotations.*;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@RequestMapping("/api/sysdict/")
public class SysDictionaryController {

    @Autowired
    private SysDictionaryService sysDictionaryService;

    @ApiOperation(value = "数据字典",notes = "根据字典编号查询字典",httpMethod = "GET")
    @ApiImplicitParam(name = "dictNo",value = "字典编号",required = true,paramType = "Integer",example = "0"
    )
    @RequestMapping(value = "dictlistbydictno",method = RequestMethod.GET)
    public List<SysDictSimpleDto> dictListByDictNo( Integer dictNo)   {
        return sysDictionaryService.querySysDictionaryByDictNo(dictNo);
    }

    @ApiOperation(value = "字典保存",notes = "字典插入和修改",httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dictCode",value = "字典编码",required = true,dataType = "integer"),
            @ApiImplicitParam(name = "dictName",value = "字典名称",required = true,dataType = "string"),
            @ApiImplicitParam(name = "dictNo",value = "字典编号",required = true,dataType = "string"),
            @ApiImplicitParam(name = "dictDesc",value = "字典描述",dataType = "string"),
            @ApiImplicitParam(name = "remarks",value = "备注",dataType = "string")
    })
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public DataResult save(@ModelAttribute("dictionary") SysDictionary dictionary)   {
        return new DataResult(sysDictionaryService.save(dictionary));
    }

    @ApiOperation(value = "删除字典",httpMethod = "DELETE")
    @ApiImplicitParam(name = "ids",value = "删除字典字符串例如‘1,2,3,4’",required = true,dataType = "string")
    @RequestMapping(value = "delete",method = RequestMethod.DELETE)
    public DataResult delete(String ids) {
        String [] idarr = ids.split(",");
        return new DataResult(true,sysDictionaryService.delete(idarr));
    }

}
