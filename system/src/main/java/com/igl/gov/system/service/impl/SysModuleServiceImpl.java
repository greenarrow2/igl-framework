package com.igl.gov.system.service.impl;

import com.igl.gov.common.api.DataGridResult;
import com.igl.gov.common.exception.IglException;
import com.igl.gov.common.utils.StringUtils;
import com.igl.gov.system.dao.SysModuleDao;
import com.igl.gov.system.dto.SysModuleDto;
import com.igl.gov.system.dto.SysModuleTreeDto;
import com.igl.gov.system.entity.SysModule;
import com.igl.gov.system.param.SysModuleParam;
import com.igl.gov.system.service.SysModuleService;
import com.sun.javafx.collections.MappingChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysModuleServiceImpl implements SysModuleService {

    @Autowired
    private SysModuleDao sysModuleDao;

    @Override
    public DataGridResult<SysModuleDto> queryPageList(SysModuleParam param){
        List<SysModuleDto> list = sysModuleDao.query(param);
        int count = sysModuleDao.count(param);
        return  new DataGridResult(param,count,list);
    }

    @Override
    public SysModule save(SysModule module){
        if(module.getId() != null){
            Map<String,Object> param = new HashMap<>(2);
               param.put("moduleCode",module.getModuleCode());
               param.put("id",module.getId());
            if(sysModuleDao.countByModuleCode(param) > 0){
                throw new IglException("你修改的模块编号已被占用！");
            }
            sysModuleDao.update(module);
            return  module;
        }
        Map<String,Object> param = new HashMap<>(2);
        param.put("moduleCode",module.getModuleCode());
        if(sysModuleDao.countByModuleCode(param) > 0){
            throw new IglException("你添加的模块编号已被占用！");
        }
        sysModuleDao.insert(module);
        return module;
    }

    @Override
    public int delete(String ids){
         if(StringUtils.isEmpty(ids)){
             throw new IglException("你传递的参数不能为空！");
         }
         String [] idArr = ids.split(",");
         Map<String,Object> param = new HashMap<>(1);
             param.put("ids",idArr);
         return sysModuleDao.delete(param);
    }

    @Override
    public List<SysModuleTreeDto> queryModuleTree(Integer id) {
        if(id == null){
           Map<String,Object> param = new HashMap();
           List<SysModuleTreeDto> parentList =  sysModuleDao.queryModuleList(param);
           queryModuleChildren(parentList,true);
           return parentList;
        }
        Map<String,Object> param = new HashMap();
           param.put("id",id);
        List<SysModuleTreeDto> parentList =  sysModuleDao.queryModuleList(param);
        queryModuleChildren(parentList,true);
        return parentList;
    }

    /**
     * 查询出自己子菜单
     * @param moduleTreeDtos
     * @param flag 是否循环查询
     */
    protected void queryModuleChildren(List<SysModuleTreeDto> moduleTreeDtos,boolean flag){
        if(CollectionUtils.isEmpty(moduleTreeDtos)){
            return;
        }
        for (int i = 0;i < moduleTreeDtos.size();i++){
            SysModuleTreeDto moduleTreeDto = moduleTreeDtos.get(i);
            Map<String,Object> param = new HashMap();
               param.put("pid",moduleTreeDto.getId());
              List<SysModuleTreeDto> moduleTree = sysModuleDao.queryModuleList(param);
              moduleTreeDto.getModuleTree().addAll(moduleTree);
              if (flag){
                  queryModuleChildren(moduleTree,flag);
              }
        }
    }
}
