package com.igl.gov.system.service.impl;

import com.igl.gov.common.api.DataGridResult;
import com.igl.gov.common.utils.DtoToMapUtils;
import com.igl.gov.common.utils.ResultUtils;
import com.igl.gov.redis.cache.RedisCache;
import com.igl.gov.redis.util.RedisConst;
import com.igl.gov.system.dao.SysDictionaryDao;
import com.igl.gov.system.dto.SysDictSimpleDto;
import com.igl.gov.system.dto.SysDictionaryDto;
import com.igl.gov.system.entity.SysDictionary;
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
    public List<SysDictSimpleDto> querySysDictionaryByDictNo(Integer dictNo) {
      List<SysDictSimpleDto> dictionaryDtos = redisCache.getListCache(RedisConst.SYS_DICT + dictNo,SysDictSimpleDto.class );
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
    public DataGridResult<SysDictionaryDto> queryPageList(Map<String, Object> param) {
        DtoToMapUtils.paramToPageMap(param);
        List<SysDictionaryDto> list = sysDictionaryDao.query(param);
        int count = sysDictionaryDao.count(param);
        return new DataGridResult<>(Integer.parseInt(param.get("page").toString()),Integer.parseInt(param.get("rows").toString()),count,list);
    }
}
