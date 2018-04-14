package com.igl.gov.system.service.impl;

import com.igl.gov.common.api.DataGridResult;
import com.igl.gov.common.utils.ResultUtils;
import com.igl.gov.redis.cache.RedisCache;
import com.igl.gov.redis.util.RedisConst;
import com.igl.gov.system.dao.SysDictionaryDao;
import com.igl.gov.system.dto.SysDictionaryDto;
import com.igl.gov.system.dto.SysDictionarySimpleDto;
import com.igl.gov.system.dto.SysDictionaryTreeDto;
import com.igl.gov.system.entity.SysDictionary;
import com.igl.gov.system.param.SysDictionaryParam;
import com.igl.gov.system.service.SysDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysDictionaryServiceImpl  implements SysDictionaryService{

    @Autowired
    private SysDictionaryDao sysDictionaryDao;

    @Autowired
    private RedisCache redisCache;


    @Override
    public List<SysDictionarySimpleDto> querySysDictionaryByDictNo(Integer dictNo) {
      List<SysDictionarySimpleDto> dictionaryDtos = redisCache.getListCache(RedisConst.SYS_DICT + dictNo,SysDictionarySimpleDto.class );
       if(dictionaryDtos == null || dictionaryDtos.size() == 0){
           Map<String,Object> param = new HashMap<>(1);
           param.put("dictNo",dictNo);
           dictionaryDtos =  sysDictionaryDao.querySysDictionaryByDictNo(param);
           redisCache.putListCache(RedisConst.SYS_DICT + dictNo,dictionaryDtos);
       }
        return  dictionaryDtos;
    }

    @Override
    public ResultUtils save(SysDictionary dictionary) {
        ResultUtils result = new ResultUtils();
        if(dictionary.getId() != null){
           sysDictionaryDao.update(dictionary);
           result.setSuccess(true);
           result.setMessage("更新成功！");
           return result;
        }
        if(sysDictionaryDao.countSysDictByDictCode(dictionary.getDictCode()) > 0){
            result.setSuccess(false);
            result.setMessage("你保存的字典编码已存在！");
            return result;
        }
        sysDictionaryDao.insert(dictionary);
        result.setSuccess(true);
        result.setMessage("保存成功！");
        return result;
    }

    @Override
    public int delete(String[] ids) {
        Map<String,Object> param = new HashMap<>(1);
         param.put("ids",ids);
        return sysDictionaryDao.delete(param);
    }

    @Override
    public int delete(String id) {
        Map<String,Object> param = new HashMap<>(1);
        param.put("ids",id);
        return sysDictionaryDao.delete(param);
    }

    @Override
    public List<SysDictionaryDto> queryList(Map<String, Object> param) {
        return sysDictionaryDao.query(param);
    }

    @Override
    public List<SysDictionaryTreeDto> querySysDictionaryTree(Integer moduleDictNo) {
           List<SysDictionaryTreeDto>  dictionaryTreeDtos = sysDictionaryDao.queryModuleByNo(moduleDictNo);
           for (SysDictionaryTreeDto dictionaryTreeDto : dictionaryTreeDtos){
              dictionaryTreeDto.getDictNoList().addAll(sysDictionaryDao.queryDictByNo(dictionaryTreeDto.getModuleDictNo()));
           }
        return dictionaryTreeDtos;
    }

    @Override
    public DataGridResult<SysDictionaryDto> pageList(SysDictionaryParam param) {
        return new DataGridResult<>(param,sysDictionaryDao.countForPage(param),sysDictionaryDao.queryPage(param));
    }
}
