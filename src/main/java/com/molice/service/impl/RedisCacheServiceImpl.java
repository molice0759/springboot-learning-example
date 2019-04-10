package com.molice.service.impl;

import com.molice.service.LoadCallback;
import com.molice.service.RedisCacheService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    public <T> T findCache(String key, long expire, LoadCallback<T> loadCallback) {
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        T result = (T) valueOperations.get(key);
        if(result == null){
            synchronized (this){
                result = (T) valueOperations.get(key);
                if(result == null){
                    result = loadCallback.load();
                    if(result != null){
                        valueOperations.set(key,result,expire, TimeUnit.SECONDS);
                    }
                }
                return result;
            }
        }
        return result;
    }
}
