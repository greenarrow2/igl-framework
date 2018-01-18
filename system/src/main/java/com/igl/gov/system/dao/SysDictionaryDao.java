package com.igl.gov.system.dao;

import com.igl.gov.system.dto.SysDictSimpleDto;
import com.igl.gov.system.dto.SysDictionaryDto;
import com.igl.gov.system.entity.SysDictionary;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SysDictionaryDao {

    List<SysDictSimpleDto> querySysDictionaryByDictNo(Map<String,Object> param);

    int insert(SysDictionary entity);

    int update(SysDictionary entity);

}
