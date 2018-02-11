package com.igl.gov.system.service.impl;

import com.igl.gov.common.api.DataGridResult;
import com.igl.gov.common.exception.IglException;
import com.igl.gov.common.utils.StringUtils;
import com.igl.gov.system.dao.SysRoleOrganizationDao;
import com.igl.gov.system.dto.SysRoleOrganizationDto;
import com.igl.gov.system.entity.SysRoleOrganization;
import com.igl.gov.system.param.SysRoleOrganizationParam;
import com.igl.gov.system.service.SysRoleOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysRoleOrganizationServiceImpl implements SysRoleOrganizationService {

    @Autowired
    private SysRoleOrganizationDao SysRoleOrganizationDao;

    @Override
    public DataGridResult queryPageList(SysRoleOrganizationParam param) {
        List<SysRoleOrganizationDto> list = SysRoleOrganizationDao.query(param);
        int count = SysRoleOrganizationDao.count(param);
        return new DataGridResult(param,count,list);
    }

    @Override
    public SysRoleOrganization add(SysRoleOrganization roleOrganization) {
        if(SysRoleOrganizationDao.countRoleOrganization(roleOrganization) > 0){
          throw new IglException("角色已经绑定组织，请不要重复绑定！");
        }
        SysRoleOrganizationDao.insert(roleOrganization);
        return roleOrganization;
    }

    @Override
    public SysRoleOrganizationDto find(Integer id) {
        return SysRoleOrganizationDao.find(id);
    }

    @Override
    public int delete(String ids) {
        if(StringUtils.isEmpty(ids)){
            throw new IglException("参数传递不能为空！");
        }
        String [] idarr = ids.split(",");
        Map<String,Object> param = new HashMap(1);
          param.put("ids",idarr);
        return SysRoleOrganizationDao.delete(param);
    }
}
