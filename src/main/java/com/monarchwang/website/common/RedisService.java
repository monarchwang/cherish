package com.monarchwang.website.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * redis 操作封装
 */
@Service
public class RedisService<String, V> {

    private static final Logger LOG = LoggerFactory.getLogger(RedisService.class);

    @Resource
    private RedisTemplate<String, V> redisTemplate;


    public void set(String key, V value, long expireTime, TimeUnit timeUnit) {

        redisTemplate.opsForValue().set(key, value, expireTime, timeUnit);
        LOG.info("Set key=" + key + ",value=" + value + " to redis for " + expireTime + timeUnit + " success.");
    }


    public V get(String key) {
        V result = redisTemplate.opsForValue().get(key);

        LOG.info("Get key=" + key + " from redis, value=" + result + " success.");
        return result;
    }

    public void delete(String key) {
        redisTemplate.delete(key);
        LOG.info("Delete key=" + key + " success.");
    }

}
