package com.molice.web.controller.lock;

import com.crossoverjie.distributed.lock.RedisLock;
import com.molice.annotation.DataPack;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

/**
 * @author molice
 * @date 2019/3/29
 **/
@RestController
@RequestMapping("lock")
@Api(tags = "分布式锁")
public class TestLockController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestLockController.class);

    @Resource
    private RedisLock redisLock;

    @GetMapping("test")
    @DataPack
    @ApiOperation("测试")
    public Object lock() {
        String key = "key";
        String request = UUID.randomUUID().toString();
        try {
            boolean lock = redisLock.tryLock(key, request);
            if (!lock) {
                LOGGER.error("获取锁失败");
                return "获取锁失败";
            }
            LOGGER.info("获取锁成功");
            //睡眠10秒
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            redisLock.unlock(key, request);
        }

        return new Date();
    }
}
