package com.igl.gov.system.service;

import com.igl.gov.system.dto.SysDictSimpleDto;
import com.igl.gov.system.dto.SysDictionaryDto;
import com.igl.gov.system.entity.SysDictionary;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface SysDictionaryService {

    /**
     * 通过字典编号查询数据字典
     * @param dictNo 字典编号
     * @return
     */
    public List<SysDictSimpleDto> querySysDictionaryByDictNo(Integer dictNo);

    /**
     * 保存字典
     * @param dictionary
     * @return
     */
    public int save(SysDictionary dictionary);

    public int delete(String [] ids);

}
