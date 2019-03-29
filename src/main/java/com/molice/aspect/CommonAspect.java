package com.molice.aspect;

import com.crossoverjie.distributed.limit.RedisLimit;
import com.molice.exception.CommonLimitException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * 限流aop
 *
 * @author molice
 * @date 2019/3/29
 **/
@Aspect
@Component
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class CommonAspect {
    private static Logger logger = LoggerFactory.getLogger(CommonAspect.class);

    @Autowired
    private RedisLimit redisLimit;

    @Pointcut("@annotation(com.crossoverjie.distributed.annotation.CommonLimit)")
    private void check() {
    }

    @Before("check()")
    public void before(JoinPoint joinPoint) throws Exception {
        if (redisLimit == null) {
            throw new NullPointerException("redisLimit is null");
        }
        boolean limit = redisLimit.limit();
        if (!limit) {
            logger.warn("request has bean limit");
            throw new CommonLimitException("request has bean limit");
        }
    }
}
