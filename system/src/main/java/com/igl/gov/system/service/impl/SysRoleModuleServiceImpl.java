package com.igl.gov.system.service.impl;

import com.igl.gov.common.api.DataGridResult;
import com.igl.gov.common.exception.IglException;
import com.igl.gov.common.utils.StringUtils;
import com.igl.gov.system.dao.SysRoleModuleDao;
import com.igl.gov.system.dto.SysModuleTreeDto;
import com.igl.gov.system.dto.SysRoleModuleDto;
import com.igl.gov.system.dto.SysRoleModuleTreeDto;
import com.igl.gov.system.entity.SysRoleModule;
import com.igl.gov.system.param.SysRoleModuleParam;
import com.igl.gov.system.service.SysRoleModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysRoleModuleServiceImpl implements SysRoleModuleService {

    @Autowired
    private  SysRoleModuleDao sysRoleModuleDao;

    @Override
    public DataGridResult queryPageList(SysRoleModuleParam param) {
        List<SysRoleModuleDto> list = sysRoleModuleDao.query(param);
        int count = sysRoleModuleDao.count(param);
        return new DataGridResult(param,count,list);
    }

    @Override
    public SysRoleModule add(SysRoleModule roleModule) {
        if(sysRoleModuleDao.countRoleModule(roleModule) > 0){
            throw new IglException("角色已经绑定组织，请不要重复绑定！");
        }
        sysRoleModuleDao.insert(roleModule);
        return roleModule;
    }

    @Override
    public List<SysRoleModule> addList(List<SysRoleModule> roleModules) {
        for (SysRoleModule roleModule:roleModules
             ) {
            add(roleModule);
        }
        return roleModules;
    }

    @Override
    public SysRoleModuleDto find(Integer id) {
        return sysRoleModuleDao.find(id);
    }

    @Override
    public int delete(String ids) {
        if(StringUtils.isEmpty(ids)){
            throw new IglException("参数传递不能为空！");
        }
        String [] idarr = ids.split(",");
        Map<String,Object> param = new HashMap(1);
        param.put("ids",idarr);
        return sysRoleModuleDao.delete(param);
    }

    @Override
    public List<SysRoleModuleTreeDto> queryRoleModuleByRoleId(String [] roleIds) {
        Map<String,Object> param = new HashMap<>();
            param.put("roleIds",roleIds);
           List<SysRoleModuleTreeDto> roleModuleTreeDtos =  sysRoleModuleDao.queryRoleModuleByRoleIdAndModuleId(param);
            queryModuleChildren(roleIds,roleModuleTreeDtos,true);
        return roleModuleTreeDtos;
    }

    @Override
    public List<SysRoleModuleTreeDto> queryRoleModuleByRoleIdAndPid(String[] roleIds, Integer pid) {
        Map<String,Object> param = new HashMap<>();
        param.put("roleIds",roleIds);
        param.put("pid",pid);
        List<SysRoleModuleTreeDto> roleModuleTreeDtos =  sysRoleModuleDao.queryRoleModuleByRoleIdAndModuleId(param);
        return roleModuleTreeDtos;
    }

    /**
     * 查询出自己子菜单
     * @param roleModuleTreeDtos
     * @param flag 是否循环查询
     */
    protected void queryModuleChildren(String [] roleIds,List<SysRoleModuleTreeDto> roleModuleTreeDtos, boolean flag){
        if(CollectionUtils.isEmpty(roleModuleTreeDtos)){
            return;
        }
        for (int i = 0;i < roleModuleTreeDtos.size();i++){
            SysRoleModuleTreeDto moduleTreeDto = roleModuleTreeDtos.get(i);
            Map<String,Object> param = new HashMap();
            param.put("pid",moduleTreeDto.getModuleId());
            param.put("roleIds",roleIds);
            List<SysRoleModuleTreeDto> moduleTree = sysRoleModuleDao.queryRoleModuleByRoleIdAndModuleId(param);
            moduleTreeDto.getRoleModuleTrees().addAll(moduleTree);
            if (flag){
                queryModuleChildren(roleIds,moduleTree,flag);
            }
        }
    }

}
