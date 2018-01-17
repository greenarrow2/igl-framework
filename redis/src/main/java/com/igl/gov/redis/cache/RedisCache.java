package com.igl.gov.redis.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

@Component
public class RedisCache {

     @Autowired
     private RedisTemplate redisTemplate;

     @Autowired
     private StringRedisTemplate stringRedisTemplate;

     /**
      *
      * @param key
      * @param obj
      * @param <T>
      * @return
      */
     public <T> Boolean putCache(String key,T obj)  {
          try {
               final byte [] keys = key.getBytes("UTF-8");
               Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
               final byte []  objs = jackson2JsonRedisSerializer.serialize(obj);
               Object result =  redisTemplate.execute(new RedisCallback<Object>() {
                    @Override
                    public Object doInRedis(RedisConnection connection) throws DataAccessException {
                         return connection.setNX(keys, objs);
                    }
               });
               return (Boolean) result;
          } catch (UnsupportedEncodingException e) {
               e.printStackTrace();
          }
         return false;
     }
}
