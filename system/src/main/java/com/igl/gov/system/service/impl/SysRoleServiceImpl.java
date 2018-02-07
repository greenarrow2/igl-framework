package com.igl.gov.system.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.igl.gov.common.api.DataGridResult;
import com.igl.gov.common.utils.DtoToMapUtils;
import com.igl.gov.common.utils.ResultUtils;
import com.igl.gov.system.dao.SysRoleDao;
import com.igl.gov.system.dto.SysRoleDto;
import com.igl.gov.system.entity.SysRole;
import com.igl.gov.system.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleDao sysRoleDao;

    @Override
    public SysRole save(SysRole role) {
        if(role.getId() != null){
            sysRoleDao.insert(role);
            return role;
        }
        sysRoleDao.update(role);
        return role;
    }

    @Override
    public SysRoleDto find(Integer id) {
        if (id == null){
            return null;
        }
        return sysRoleDao.find(id);
    }

    @Override
    public DataGridResult<SysRoleDto> queryPageList(HttpServletRequest request) {
        Map<String,Object> param = DtoToMapUtils.requestToMapPage(request);
        DataGridResult result = new DataGridResult();
        List<SysRoleDto> list = sysRoleDao.query(param);
        int count = sysRoleDao.count(param);
        result.setItems(list);
        result.setTotalNum(count);
        return result;
    }

    @Override
    public ResultUtils delete(String ids) {
        String [] idarr = ids.split(",");
        ResultUtils result = new ResultUtils();
        Map<String,Object> param = new HashMap<>();
           param.put("ids",idarr);
        if(sysRoleDao.countChildren(param) > 0){
            result.setSuccess(false);
            result.setMessage("你选择删除的角色目录存在子角色，请删除子角色然后再删除角色目录");
            return result;
        }
        result.setSuccess(true);
        int count = sysRoleDao.delete(param);
        result.setMessage("你删除了" + count + "条数据！" );
        return result;
    }


}
