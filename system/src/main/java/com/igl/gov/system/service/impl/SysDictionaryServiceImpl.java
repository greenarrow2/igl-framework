package com.igl.gov.system.service.impl;

import com.igl.gov.redis.cache.RedisCache;
import com.igl.gov.redis.util.RedisConst;
import com.igl.gov.system.dao.SysDictionaryDao;
import com.igl.gov.system.dto.SysDictSimpleDto;
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
    public int save(SysDictionary dictionary) {
        if(dictionary.getId() != null){
           return sysDictionaryDao.update(dictionary);
        }
        return sysDictionaryDao.insert(dictionary);
    }
}
