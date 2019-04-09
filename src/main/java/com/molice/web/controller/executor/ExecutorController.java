package com.molice.web.controller.executor;

import com.molice.annotation.DataPack;
import com.molice.service.AsyncService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author molice
 * @date 2019/4/9
 **/
@RestController
@RequestMapping("executor")
@Api
public class ExecutorController {

    private static final Logger logger = LoggerFactory.getLogger(ExecutorController.class);

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/test")
    @ApiOperation("异步")
    @DataPack
    public Object submit(){
        logger.info("start submit");

        //启动一个异步任务
        asyncService.executeAsync();

        logger.info("end submit");

        return "success";
    }
}
