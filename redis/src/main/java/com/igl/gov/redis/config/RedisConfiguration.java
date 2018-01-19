package com.igl.gov.redis.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import redis.clients.jedis.JedisPoolConfig;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class RedisConfiguration{

    @Value("${igl.redis.host:127.0.0.1}")
    private String host;

    @Value("${igl.redis.port:6379}")
    private Integer port;

    @Value("${igl.redis.password:mesRedis+)}")
    private String password;

    @Value("${igl.redis.database:0}")
    private int database;

    @Value("${igl.redis.maxActive:8}")
    private int maxActive;

    @Value("${igl.redis.maxIdle:8}")
    private int maxIdle;

    @Value("${igl.redis.maxWait:-1}")
    private long maxWait;

    @Value("${igl.redis.minIdle:0}")
    private int minIdle;

    @Value("${igl.redis.hosts}")
    private String hosts;

    @Value("${igl.redis.hosts.type:sentinel}")
    private String hostsType;

    @Value("${igl.redis.sentinel.master:masterName}")
    private String sentinelMaster;

    @Value("${igl.redis.metrics.report.interval:300}")
    private int reportInterval;

    @Value("${igl.redis.keys.normalize:true}")
    private boolean keysNormalize;

    @Value("${igl.redis.keys.namespace:}")
    private String keysNamespaceStr;

    @Value("${igl.redis.cluster.max-redirects:3}")
    private int maxRedirects;

    public static final String SENTINEL = "sentinel";

    public static final String CLUSTER = "cluster";

    //因为与igl-session有冲突, 因此, jedisConnectionFactory不暴露为Bean
    //调用其afterPropertiesSet模拟Spring容器初始化
    public JedisConnectionFactory jedisConnectionFactory() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMinIdle(minIdle);
        jedisPoolConfig.setMaxTotal(maxActive);
        jedisPoolConfig.setMaxWaitMillis(maxWait);
        JedisConnectionFactory connectionFactory = null;
        if(StringUtils.hasText(hosts)){
            List<RedisNode> nodes = parseRedisNodes(hosts);
            if (CollectionUtils.isEmpty(nodes)) {
                throw new IllegalArgumentException("Invalid property configuration [sweet.redis.hosts]");
            }
            if (SENTINEL.equalsIgnoreCase(hostsType)) {
                RedisSentinelConfiguration sentinelConfiguration = new RedisSentinelConfiguration();
                sentinelConfiguration.setSentinels(nodes);
                sentinelConfiguration.setMaster(sentinelMaster);
                connectionFactory = new JedisConnectionFactory(sentinelConfiguration);
            }
            if(CLUSTER.equalsIgnoreCase(hostsType)){
                RedisClusterConfiguration clusterConfiguration = new RedisClusterConfiguration();
                clusterConfiguration.setClusterNodes(nodes);
                clusterConfiguration.setMaxRedirects(maxRedirects);
                connectionFactory = new JedisConnectionFactory(clusterConfiguration);
            }
        }
        if (connectionFactory == null) {
            connectionFactory = new JedisConnectionFactory();
            connectionFactory.setHostName(host);
            connectionFactory.setPort(port);
        }
        connectionFactory.setPassword(password);
        connectionFactory.setDatabase(database);
        connectionFactory.setPoolConfig(jedisPoolConfig);
        //模拟容器对其进行初始化
        connectionFactory.afterPropertiesSet();
        return connectionFactory;
    }

    @SuppressWarnings("rawtypes")
    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        RedisCacheManager rcm = new RedisCacheManager(redisTemplate);
        //设置缓存过期时间60s
        rcm.setDefaultExpiration(60);
        return rcm;
    }



    @Bean
    public RedisTemplate redisTemplate() {
        JedisConnectionFactory connectionFactory = jedisConnectionFactory();
        RedisTemplate template = new RedisTemplate();
        template.setConnectionFactory(connectionFactory);
        return template;
    }
    private ArrayList<RedisNode> parseRedisNodes(String hosts) {
        ArrayList<RedisNode> ret = new ArrayList<RedisNode>();
        String[] parts = hosts.split(",");
        for (String host : parts) {
            if (!StringUtils.hasText(host)) continue;
            String hostPart[] = host.split(":");
            String hostName = hostPart[0];
            if (!StringUtils.hasText(hostName)) continue;
            int port = hostPart.length > 1 ? Integer.parseInt(hostPart[1]) : 6379;
            ret.add(new RedisNode(hostName, port));
        }
        return ret;
    }
}
