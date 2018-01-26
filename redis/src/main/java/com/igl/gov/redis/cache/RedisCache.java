package com.igl.gov.redis.cache;

import com.igl.gov.common.utils.ProtoStuffSerializerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
public class RedisCache {

    private final static Logger logger = LoggerFactory.getLogger(RedisCache.class);

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * @param key
     * @param obj
     * @param <T>
     * @return
     */
    public <T> Boolean putCache(String key, T obj) {
        try {
            final byte[] keys = key.getBytes("UTF-8");
            final byte[] objs = ProtoStuffSerializerUtils.serialize(obj);
            Object result = redisTemplate.execute(new RedisCallback<Object>() {
                @Override
                public Object doInRedis(RedisConnection connection) throws DataAccessException {
                    return connection.setNX(keys, objs);
                }
            });
            return (Boolean) result;
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getLocalizedMessage(), e);
        }
        return false;
    }

    public <T> void putCacheWithExpireTime(String key, T obj, final long expireTime) {
        try {
            final byte[] bkey = key.getBytes("UTF8");
            final byte[] bvalue = ProtoStuffSerializerUtils.serialize(obj);
            redisTemplate.execute(new RedisCallback<Boolean>() {
                @Override
                public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                    connection.setEx(bkey, expireTime, bvalue);
                    return true;
                }
            });
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getLocalizedMessage(), e);
        }
    }

    public <T> boolean putListCache(String key, List<T> objList){
        try {
            final byte[] bkey = key.getBytes("UTF8");
            final byte[] bvalue = ProtoStuffSerializerUtils.serializeList(objList);
            Object result = redisTemplate.execute(new RedisCallback<Object>() {
                @Override
                public Object doInRedis(RedisConnection connection) throws DataAccessException {
                    return connection.setNX(bkey, bvalue);
                }
            });
            return (Boolean) result;
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getLocalizedMessage(), e);
        }
        return false;
    }

    public <T> boolean putListCacheWithExpireTime(String key, List<T> objList, final long expireTime) {
        try {
            final byte[] bkey = key.getBytes("UTF8");
            final byte[] bvalue = ProtoStuffSerializerUtils.serializeList(objList);
            Object result = redisTemplate.execute(new RedisCallback<Object>() {
                @Override
                public Object doInRedis(RedisConnection connection) throws DataAccessException {
                    connection.setEx(bkey, expireTime, bvalue);
                    return true;
                }
            });
            return (Boolean) result;
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getLocalizedMessage(), e);
        }
        return false;
    }

    public <T> T getCache(final String key, Class<T> targetClass) {
        byte[] result = (byte[]) redisTemplate.execute(new RedisCallback<byte[]>() {
            @Override
            public byte[] doInRedis(RedisConnection connection) throws DataAccessException {
                byte[] k = new byte[0];
                try {
                    k = connection.get(key.getBytes("UTF8"));
                } catch (UnsupportedEncodingException e) {
                    logger.error(e.getMessage(), e);
                }
                return k;
            }
        });
        return ProtoStuffSerializerUtils.deserialize(result, targetClass);
    }

    public <T> List<T> getListCache(final String key, Class<T> targetClass) {
        byte[] result = (byte[]) redisTemplate.execute(new RedisCallback<byte[]>() {
            @Override
            public byte[] doInRedis(RedisConnection connection) throws DataAccessException {
                byte[] k = new byte[0];
                try {
                    k = connection.get(key.getBytes("UTF8"));
                } catch (UnsupportedEncodingException e) {
                    logger.error(e.getMessage(), e);
                }
                return k;
            }
        });
        if (result == null) {
            return Collections.emptyList();
        }

        return ProtoStuffSerializerUtils.deserializeList(result, targetClass);
    }

    /**
     * 获取key 集合
     *
     * @param pattern
     * @return
     */
    public Set<String> getCacheWithPattern(String pattern) {
        return redisTemplate.keys(pattern);
    }

    /**
     * 精确删除key
     *
     * @param key
     */
    public void deleteCache(String key) {
        try {
            final byte[] bkey = key.getBytes("UTF8");
            Object result = redisTemplate.execute(new RedisCallback<Object>() {
                @Override
                public Object doInRedis(RedisConnection connection) throws DataAccessException {
                    connection.del(bkey);
                    return true;
                }
            });
        } catch (UnsupportedEncodingException e) {
            logger.error(e.getLocalizedMessage(), e);
        }
    }

    /**
     * 模糊删除key
     *
     * @param pattern
     */
    public void deleteCacheWithPattern(String pattern) {
        Set<String> keys = redisTemplate.keys(pattern);
        redisTemplate.delete(keys);
    }

    /**
     * 延时缓存
     */
    public void flushCache(String key, long delayTime) {
        redisTemplate.expire(key, delayTime, TimeUnit.SECONDS);
    }

}
