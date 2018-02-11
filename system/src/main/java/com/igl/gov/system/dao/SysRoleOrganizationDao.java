package com.igl.gov.system.dao;

import com.igl.gov.system.dto.SysRoleOrganizationDto;
import com.igl.gov.system.entity.SysRoleOrganization;
import com.igl.gov.system.param.SysRoleOrganizationParam;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Map;

@Mapper
public interface SysRoleOrganizationDao {

    List<SysRoleOrganizationDto> query(SysRoleOrganizationParam param);

    int count(SysRoleOrganizationParam param);

    int insert(SysRoleOrganization roleOrganization);

    int delete(Map<String,Object> param);

    SysRoleOrganizationDto find(Integer id);

    int countRoleOrganization(SysRoleOrganization roleOrganization);
}
