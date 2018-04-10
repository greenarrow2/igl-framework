package com.igl.gov.system.controller;

import com.igl.gov.common.api.DataGridResult;
import com.igl.gov.common.api.DataResult;
import com.igl.gov.system.dto.SysDictionaryDto;
import com.igl.gov.system.dto.SysDictionarySimpleDto;
import com.igl.gov.system.dto.SysDictionaryTreeDto;
import com.igl.gov.system.entity.SysDictionary;
import com.igl.gov.system.param.SysDictionaryParam;
import com.igl.gov.system.service.SysDictionaryService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/sysdict/")
public class SysDictionaryController {

    @Autowired
    private SysDictionaryService sysDictionaryService;

    @ApiOperation(value = "数据字典",notes = "根据字典编号查询字典")
    @ApiImplicitParam(name = "dictNo",value = "字典编号",required = true,paramType = "query",dataType = "integer"
    )
    @RequestMapping(value = "dictlistbydictno",method = RequestMethod.POST)
    public List<SysDictionarySimpleDto> dictListByDictNo(Integer dictNo)   {
        return sysDictionaryService.querySysDictionaryByDictNo(dictNo);
    }

    @ApiOperation(value = "字典保存",notes = "字典插入和修改")
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public DataResult save( @RequestBody SysDictionary dictionary)   {
        return new DataResult(sysDictionaryService.save(dictionary));
    }

    @ApiOperation(value = "删除字典",httpMethod = "POST")
    @ApiImplicitParam(name = "ids",value = "删除字典字符串例如‘1,2,3,4’",required = true,dataType = "string",paramType = "query")
    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public DataResult delete(String ids) {
        String [] idarr = ids.split(",");
        return new DataResult(true,sysDictionaryService.delete(idarr));
    }

    @ApiOperation(value = "数据字典查询")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "dictNo",value = "字典编号", paramType = "query",dataType = "integer"),
                    @ApiImplicitParam(name = "dictName",value = "字典名称", paramType = "query",dataType = "string"),
                    @ApiImplicitParam(name = "dictCode",value = "字典编码", paramType = "query",dataType = "integer"),
                    @ApiImplicitParam(name = "moduleDictNo",value = "模块字典编号", paramType = "query",dataType = "integer"),
            }
    )
    @RequestMapping(value = "list",method = RequestMethod.POST)
    public List<SysDictionaryDto> list(Integer dictNo, String dictName, Integer dictCode,Integer moduleDictNo){
        Map<String,Object> param = new HashMap<>();
           param.put("dictNo",dictNo);
           param.put("dictName",dictName);
           param.put("dictCode",dictCode);
        return sysDictionaryService.queryList(param);
    }

    @ApiOperation(value = "左侧字典菜单")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "moduleDictNo",value = "模块字典编号", paramType = "query",dataType = "integer"),
            }
    )
    @RequestMapping(value = "querydicttree",method = RequestMethod.POST)
    public List<SysDictionaryTreeDto> queryDictTree(Integer moduleDictNo){
        return sysDictionaryService.querySysDictionaryTree(moduleDictNo);
    }


    @ApiOperation(value = "分页查询")
    @RequestMapping(value = "pagelist",method = RequestMethod.POST)
    public DataGridResult<SysDictionaryDto> pageList(SysDictionaryParam param){
        return sysDictionaryService.pageList(param);
    }
}
