package com.igl.gov.system.service;

import com.igl.gov.system.dto.SysDictionaryDto;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface SysDictionaryService {

    /**
     * 通过字典编号查询数据字典
     * @param dictNo 字典编号
     * @return
     */
    public List<SysDictionaryDto> querySysDictionaryByDictNo(Integer dictNo) throws UnsupportedEncodingException;

}
