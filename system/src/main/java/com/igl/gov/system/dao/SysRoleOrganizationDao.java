package com.igl.gov.system.dao;

import com.igl.gov.system.dto.SysRoleOrganizationDto;
import com.igl.gov.system.entity.SysRole;
import com.igl.gov.system.entity.SysRoleOrganization;
import com.igl.gov.system.param.SysRoleOrganizationParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysRoleOrganizationDao {

    List<SysRoleOrganizationDto> query(SysRoleOrganizationParam param);

    int count(SysRoleOrganizationParam param);

    int insert(SysRoleOrganization roleOrganization);

}
