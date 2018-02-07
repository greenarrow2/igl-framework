package com.igl.gov.system.service.impl;

import com.igl.gov.common.api.DataGridResult;
import com.igl.gov.common.exception.IglException;
import com.igl.gov.common.utils.StringUtils;
import com.igl.gov.system.dao.SysOrganizationDao;
import com.igl.gov.system.dto.SysOrganizationDto;
import com.igl.gov.system.entity.SysOrganization;
import com.igl.gov.system.param.SysOrganizationParam;
import com.igl.gov.system.service.SysOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysOrganizationServiceImpl implements SysOrganizationService{

    @Autowired
     private SysOrganizationDao sysOrganizationDao;

    @Override
    public DataGridResult queryPageList(SysOrganizationParam param) {
            List<SysOrganizationDto> organizationDtos = sysOrganizationDao.query(param);
            int count = sysOrganizationDao.count(param);
            DataGridResult result = new DataGridResult(param,count,organizationDtos);
            return result;
    }

    @Override
    public SysOrganization save(SysOrganization organization) {
        if(organization.getId() != null){
            sysOrganizationDao.update(organization);
            return organization;
        }
        if(sysOrganizationDao.countByOrgCode(organization.getOrgCode()) > 0){
            throw new IglException("组织编号：" + organization.getOrgCode() + "已经存在，请重新换一个!");
        }
        sysOrganizationDao.insert(organization);
        return organization;
    }

    @Override
    public Integer delete(String ids) {
        if(StringUtils.isEmpty(ids)){
            throw new IglException("参数不能为空");
        }
        String [] idarr = ids.split(",");
        Map<String,Object> param = new HashMap<>(1);
           param.put("ids",idarr);
           if(sysOrganizationDao.countChildren(param) > 0){
               throw new IglException("存在子组织，请先删除子组织后再删除！");
           }
        return sysOrganizationDao.delete(param);
    }
}
