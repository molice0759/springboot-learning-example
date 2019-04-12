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
    <T extends Object> T findCache(String key, Long expire, LoadCallback<T> loadCallback);

    <T extends Object> T findCache(String key, LoadCallback<T> loadCallback);

    <T extends Object> T findCache(String key);

    /**
     * 自增长数字缓存
     * @param key
     * @param increment
     */
    long incrementCache(String key, long increment);

    int incrementCache(String key, int increment);

    /**
     * 删除指定的key
     * @param key
     */
    void remove(String key);

    /**
     * 模糊删除
     * @param pattern
     */
    void removeByPattern(String pattern);
}
