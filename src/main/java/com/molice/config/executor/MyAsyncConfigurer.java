package com.molice.config.executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;

/**
 * 通过实现AsyncConfigurer自定义异常线程池，包含异常处理
 *
 * @author molice
 * @date 2019/4/10
 **/
@Component
public class MyAsyncConfigurer implements AsyncConfigurer {

    private static final Logger log = LoggerFactory.getLogger(MyAsyncConfigurer.class);

    @Autowired
    private ExecutorConfig executorConfig;

    @Override
    public Executor getAsyncExecutor() {
        return executorConfig.asyncServiceExecutor();
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new MyAsyncExceptionHandler();
    }

    /**
     * 自定义异常处理类
     * @author molice
     */
    class MyAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {
        @Override
        public void handleUncaughtException(Throwable throwable, Method method, Object... obj) {
            log.info("Exception message - " + throwable.getMessage());
            log.info("Method name - " + method.getName());
            for (Object param : obj) {
                log.info("Parameter value - " + param);
            }
        }
    }
}

