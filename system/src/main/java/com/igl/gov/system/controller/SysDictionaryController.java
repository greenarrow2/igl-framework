package com.igl.gov.system.controller;

import com.igl.gov.common.api.DataGridResult;
import com.igl.gov.common.api.DataResult;
import com.igl.gov.system.dto.SysDictSimpleDto;
import com.igl.gov.system.dto.SysDictionaryDto;
import com.igl.gov.system.entity.SysDictionary;
import com.igl.gov.system.service.SysDictionaryService;
import io.swagger.annotations.*;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "数据字典")
@RestController
@RequestMapping("/api/sysdict/")
public class SysDictionaryController {

    @Autowired
    private SysDictionaryService sysDictionaryService;

    @ApiOperation(value = "数据字典",notes = "根据字典编号查询字典")
    @ApiImplicitParam(name = "dictNo",value = "字典编号",required = true,paramType = "query",dataType = "integer"
    )
    @RequestMapping(value = "dictlistbydictno",method = RequestMethod.POST)
    public List<SysDictSimpleDto> dictListByDictNo( Integer dictNo)   {
        return sysDictionaryService.querySysDictionaryByDictNo(dictNo);
    }

    @ApiOperation(value = "字典保存",notes = "字典插入和修改")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dictCode",value = "字典编码",required = true,dataType = "integer",paramType = "form"),
            @ApiImplicitParam(name = "dictName",value = "字典名称",required = true,dataType = "string",paramType = "form"),
            @ApiImplicitParam(name = "dictNo",value = "字典编号",required = true,dataType = "string",paramType = "form"),
            @ApiImplicitParam(name = "dictDesc",value = "字典描述",dataType = "string",paramType = "form"),
            @ApiImplicitParam(name = "remarks",value = "备注",dataType = "string",paramType = "form")
    })
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public DataResult save(@ModelAttribute("dictionary") SysDictionary dictionary)   {
        return new DataResult(sysDictionaryService.save(dictionary));
    }

    @ApiOperation(value = "删除字典",httpMethod = "DELETE")
    @ApiImplicitParam(name = "ids",value = "删除字典字符串例如‘1,2,3,4’",required = true,dataType = "string",paramType = "query")
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public DataResult delete(String ids) {
        String [] idarr = ids.split(",");
        return new DataResult(true,sysDictionaryService.delete(idarr));
    }

    @ApiOperation(value = "数据字典分页查询")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "page",value = "当前页",required = true,paramType = "query",dataType = "integer"),
                    @ApiImplicitParam(name = "rows",value = "条数",required = true,paramType = "query",dataType = "integer"),
                    @ApiImplicitParam(name = "dictNo",value = "字典编号", paramType = "query",dataType = "integer"),
                    @ApiImplicitParam(name = "dictName",value = "字典名称", paramType = "query",dataType = "string"),
                    @ApiImplicitParam(name = "dictCode",value = "字典编码", paramType = "query",dataType = "integer"),
            }
    )
    @RequestMapping(value = "pagelist",method = RequestMethod.POST)
    public DataGridResult<SysDictionaryDto> pageList(Integer page,Integer rows,  Integer dictNo, String dictName, Integer dictCode){
        Map<String,Object> param = new HashMap<>();
           param.put("page",page);
           param.put("rows",rows);
           param.put("dictNo",dictNo);
           param.put("dictName",dictName);
           param.put("dictCode",dictCode);
        return sysDictionaryService.queryPageList(param);
    }
}
