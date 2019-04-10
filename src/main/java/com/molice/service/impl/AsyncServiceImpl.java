package com.molice.service.impl;

import com.molice.exception.ServiceException;
import com.molice.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * 异步任务实现类
 * @author molice
 * @date 2019/1/23
 **/
@Service
public class AsyncServiceImpl implements AsyncService {

    private static final Logger logger = LoggerFactory.getLogger(AsyncServiceImpl.class);

    @Override
    @Async("asyncServiceExecutor")
    public void executeAsync() {
        logger.info("start executeAsync");
        try{
            Thread.sleep(1000);
        }catch(Exception e){
            e.printStackTrace();
        }
        logger.info("end executeAsync");
    }

    /**
     * 对于返回值是void，异常会被AsyncUncaughtExceptionHandler处理掉
     * @param param
     */
    @Override
    @Async("asyncServiceExecutor")
    public void executeAsyncWithParameter(String param) {
        logger.info("executeAsyncWithParameter,parameter={}", param);
        throw new ServiceException("异步异常");

    }

    /**
     * 返回值是Futrue的异步方法异常捕获:a) 一种是在调用future的get时捕获异常; b) 在异常方法中直接捕获异常
     * 对于返回值是Future，不会被AsyncUncaughtExceptionHandler处理，需要我们在方法中捕获异常并处理
     * 或者在调用方在调用Futrue.get时捕获异常进行处理
     * @param count
     * @return
     */
    @Override
    @Async("asyncServiceExecutor")
    public Future<String> executeAsyncReturnFuture(int count) {
        logger.info("executeAsyncReturnFuture,parameter={}", count);
        Future<String> future;
        try {
            Thread.sleep(100);
            future = new AsyncResult<>("success" + count);
        } catch (InterruptedException e) {
            e.printStackTrace();
            future = new AsyncResult<>("error");
        }

        return future;
    }

}
