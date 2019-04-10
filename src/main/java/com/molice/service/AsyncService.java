package com.molice.service;

import java.util.concurrent.Future;

/**
 * 执行异步任务接口
 * @author molice
 * @date 2019/1/23
 **/
public interface AsyncService {

    /**
     * 执行异步任务
     */
    void executeAsync();

    /**
     * 执行异步任务 带参数
     * @param param
     */
    void executeAsyncWithParameter(String param);

    /**
     * 执行异步 返回参数
     * @param count
     * @return
     */
    Future<String> executeAsyncReturnFuture(int count);
}
