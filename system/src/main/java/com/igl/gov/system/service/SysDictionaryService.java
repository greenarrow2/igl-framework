package com.igl.gov.system.service;

import com.igl.gov.common.api.DataGridResult;
import com.igl.gov.common.utils.ResultUtils;
import com.igl.gov.system.dto.SysDictionarySimpleDto;
import com.igl.gov.system.dto.SysDictionaryDto;
import com.igl.gov.system.dto.SysDictionaryTreeDto;
import com.igl.gov.system.entity.SysDictionary;
import com.igl.gov.system.param.SysDictionaryParam;

import java.util.List;
import java.util.Map;

public interface SysDictionaryService {

    /**
     * 通过字典编号查询数据字典
     * @param dictNo 字典编号
     * @return
     */
    public List<SysDictionarySimpleDto> querySysDictionaryByDictNo(Integer dictNo);

    /**
     * 保存字典
     * @param dictionary
     * @return
     */
    public ResultUtils save(SysDictionary dictionary);

    public int delete(String [] ids);

    public List<SysDictionaryDto> queryList(Map<String,Object> param);

    public List<SysDictionaryTreeDto> querySysDictionaryTree(Integer moduleDictNo);

    public DataGridResult<SysDictionaryDto> pageList(SysDictionaryParam param);

}
