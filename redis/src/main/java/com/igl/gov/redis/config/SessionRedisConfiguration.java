package com.igl.gov.redis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ArrayList;

@EnableRedisHttpSession
public class SessionRedisConfiguration {

    @Value("${igl.session.redis.host:127.0.0.1}")
    private String host;

    @Value("${igl.session.redis.port:6379}")
    private Integer port;

    @Value("${igl.session.redis.password:mesRedis+)}")
    private String password;

    @Value("${igl.session.redis.database:0}")
    private int database;

    @Value("${igl.session.redis.maxActive:8}")
    private int maxActive;

    @Value("${igl.session.redis.maxIdle:8}")
    private int maxIdle;

    @Value("${igl.session.redis.maxWait:-1}")
    private long maxWait;

    @Value("${igl.session.redis.minIdle:0}")
    private int minIdle;

    @Value("${igl.session.redis.hosts}")
    private String hosts;

    @Value("${igl.session.redis.hosts.type:sentinel}")
    private String hostsType;

    @Value("${igl.session.redis.sentinel.master:masterName}")
    private String sentinelMaster;

    @Value("${igl.session.redis.metrics.report.interval:300}")
    private int reportInterval;

    @Value("${igl.session.redis.keys.normalize:true}")
    private boolean keysNormalize;

    @Value("${igl.session.redis.keys.namespace:}")
    private String keysNamespaceStr;

    @Value("${igl.session.redis.cluster.max-redirects:3}")
    private int maxRedirects;

    public static final String SENTINEL = "sentinel";

    public static final String CLUSTER = "cluster";



    @Bean
    public JedisConnectionFactory connectionFactory(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMinIdle(minIdle);
        jedisPoolConfig.setMaxTotal(maxActive);
        jedisPoolConfig.setMaxWaitMillis(maxWait);


        JedisConnectionFactory connectionFactory = null;

        if (StringUtils.hasText(hosts)) {
            ArrayList<RedisNode> hostAndPorts = parseRedisNodes(hosts);
            if (CollectionUtils.isEmpty(hostAndPorts)) {
                throw new IllegalArgumentException("Invalid property configuration [sweet.session.redis.hosts]");
            }
            if (SENTINEL.equalsIgnoreCase(hostsType)) {
                RedisSentinelConfiguration sentinelConfiguration = new RedisSentinelConfiguration();
                sentinelConfiguration.setSentinels(hostAndPorts);
                sentinelConfiguration.setMaster(sentinelMaster);
                connectionFactory = new JedisConnectionFactory(sentinelConfiguration);
            }
            else if (CLUSTER.equalsIgnoreCase(hostsType)) {
                RedisClusterConfiguration clusterConfiguration = new RedisClusterConfiguration();
                clusterConfiguration.setClusterNodes(hostAndPorts);
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

        return connectionFactory;
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
