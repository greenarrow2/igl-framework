package com.igl.gov.system.dao;

import com.igl.gov.system.dto.SysDictionaryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SysDictionaryDao {

    List<SysDictionaryDto> querySysDictionaryByDictNo(Map<String,Object> param);

}
