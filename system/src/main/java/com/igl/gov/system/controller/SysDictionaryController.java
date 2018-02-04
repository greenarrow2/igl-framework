package com.igl.gov.system.controller;

import com.igl.gov.common.api.DataResult;
import com.igl.gov.system.dto.SysDictSimpleDto;
import com.igl.gov.system.dto.SysDictionaryDto;
import com.igl.gov.system.entity.SysDictionary;
import com.igl.gov.system.service.SysDictionaryService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @ApiOperation(value = "数据字典",notes = "根据字典编号查询字典" )
    @ApiImplicitParam(name = "dictNo",value = "字典编号",required = true,paramType = "Integer",example = "0"
    )
    @RequestMapping(value = "dictlistbydictno")
    public List<SysDictSimpleDto> dictListByDictNo( Integer dictNo)   {
        return sysDictionaryService.querySysDictionaryByDictNo(dictNo);
    }

    @RequestMapping(value = "save",method = RequestMethod.GET)
    public DataResult save(SysDictionary dictionary)   {
        return new DataResult(true,sysDictionaryService.save(dictionary));
    }

    @RequestMapping(value = "delete")
    public DataResult delete(String ids) throws UnsupportedEncodingException {
        String [] idarr = ids.split(",");
        return new DataResult(true,sysDictionaryService.delete(idarr));
    }

}
