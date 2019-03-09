package com.molice.springbootlearningexample.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 测试swagger
 * @author molice
 * @date 2019/3/9
 **/
@RestController
@Api("测试controller")
public class TestController {


    @GetMapping("test")
    @ApiOperation("测试test")
    public Date test() {
        return new Date();
    }
}
