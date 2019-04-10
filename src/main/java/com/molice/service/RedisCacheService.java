package com.molice.service;

/**
 * @author molice
 * @date 2019/4/10
 **/
public interface RedisCacheService {

    /**
     * @param key          key
     * @param expire       超时时间秒
     * @param loadCallback 数据加载回调
     * @param <T>
     * @return
     */
    <T extends Object> T findCache(String key, long expire, LoadCallback<T> loadCallback);
}
