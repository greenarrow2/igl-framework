package com.igl.gov.system.dao;

import com.igl.gov.system.dto.SysOrganizationDto;
import com.igl.gov.system.entity.SysOrganization;
import com.igl.gov.system.param.SysOrganizationParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SysOrganizationDao {

    List<SysOrganizationDto> query(SysOrganizationParam dto);

    int countByOrgCode(String orgCode);

    int count(SysOrganizationParam dto);

    int  insert(SysOrganization organization);

    int  update(SysOrganization organization);

    int  delete(Map<String,Object> param);

    SysOrganizationDto find(Integer id);

    int countChildren(Map<String,Object> param);
}
