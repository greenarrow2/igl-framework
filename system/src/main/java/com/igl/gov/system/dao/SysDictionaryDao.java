package com.igl.gov.system.dao;

import com.igl.gov.system.dto.SysDictionarySimpleDto;
import com.igl.gov.system.dto.SysDictionaryDto;
import com.igl.gov.system.dto.SysDictionaryNoDto;
import com.igl.gov.system.dto.SysDictionaryTreeDto;
import com.igl.gov.system.entity.SysDictionary;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SysDictionaryDao {

    List<SysDictionarySimpleDto> querySysDictionaryByDictNo(Map<String,Object> param);

    int insert(SysDictionary entity);

    int update(SysDictionary entity);

    int delete(Map<String,Object> param);

    int countSysDictByDictCode(Integer dictCode);

    List<SysDictionaryDto> query(Map<String,Object> param);

    int count(Map<String,Object> param);

    List<SysDictionaryTreeDto> queryModuleByNo(Integer moduleDictNo);

    List<SysDictionaryNoDto> queryDictByNo(Integer moduleDictNo);

}
