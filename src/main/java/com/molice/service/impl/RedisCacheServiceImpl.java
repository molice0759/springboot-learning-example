package com.molice.service.impl;

import com.baomidou.mybatisplus.toolkit.CollectionUtils;
import com.molice.service.LoadCallback;
import com.molice.service.RedisCacheService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.support.atomic.RedisAtomicInteger;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author molice
 * @date 2019/4/10
 **/
@Service
public class RedisCacheServiceImpl implements RedisCacheService {
    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    public <T extends Object> T findCache(String key, Long expire, LoadCallback<T> loadCallback) {
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        T result = (T) valueOperations.get(key);
        if(result == null){
            synchronized (this){
                result = (T) valueOperations.get(key);
                if(result == null){
                    result = loadCallback.load();
                    if(result != null){
                        valueOperations.set(key,result,expire,TimeUnit.SECONDS);
                    }
                }
                return result;
            }
        }
        return result;
    }


    @Override
    public <T extends Object> T findCache(String key, LoadCallback<T> loadCallback) {
        return this.findCache(key,null,loadCallback);
    }

    @Override
    public <T> T findCache(String key) {
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        T result = (T) valueOperations.get(key);
        return result;
    }

    @Override
    public long incrementCache(String key, long increment) {
        RedisAtomicLong redisAtomicLong = new RedisAtomicLong(key, redisTemplate.getConnectionFactory());
        return redisAtomicLong.addAndGet(increment);
    }

    @Override
    public int incrementCache(String key, int increment) {
        RedisAtomicInteger redisAtomicInteger = new RedisAtomicInteger(key, redisTemplate.getConnectionFactory());
        return redisAtomicInteger.addAndGet(increment);
    }

    @Override
    public void remove(String key) {
        if(redisTemplate.hasKey(key)){
            redisTemplate.delete(key);
        }
    }

    @Override
    public void removeByPattern(String pattern) {
        Set<String> keys = redisTemplate.keys(pattern);
        if (CollectionUtils.isNotEmpty(keys)) {
            redisTemplate.delete(keys);
        }
    }
}
