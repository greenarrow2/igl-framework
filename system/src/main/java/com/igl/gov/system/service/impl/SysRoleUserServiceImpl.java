package com.igl.gov.system.service.impl;

import com.igl.gov.common.api.DataGridResult;
import com.igl.gov.common.exception.IglException;
import com.igl.gov.common.utils.StringUtils;
import com.igl.gov.system.dao.SysRoleUserDao;
import com.igl.gov.system.dto.SysRoleUserDto;
import com.igl.gov.system.entity.SysRoleUser;
import com.igl.gov.system.param.SysRoleUserParam;
import com.igl.gov.system.service.SysRoleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysRoleUserServiceImpl implements SysRoleUserService {

    @Autowired
    private SysRoleUserDao sysRoleUserDao;

    @Override
    public DataGridResult queryPageList(SysRoleUserParam param) {
        List<SysRoleUserDto> list = sysRoleUserDao.query(param);
        int count = sysRoleUserDao.count(param);
        return new DataGridResult(param,count,list);
    }

    @Override
    public SysRoleUser add(SysRoleUser roleUser) {
        if(sysRoleUserDao.countRoleUser(roleUser) > 0){
            new IglException("用户角色已经绑定，请不要重复绑定！");
        }
        sysRoleUserDao.insert(roleUser);
        return roleUser;
    }

    @Override
    public SysRoleUserDto find(Integer id) {
        return sysRoleUserDao.find(id);
    }

    @Override
    public int delete(String ids) {
        if(StringUtils.isEmpty(ids)){
            throw new IglException("参数传递不能为空！");
        }
        String [] idarr = ids.split(",");
        Map<String,Object> param = new HashMap(1);
          param.put("ids",idarr);
        return sysRoleUserDao.delete(param);
    }
}
