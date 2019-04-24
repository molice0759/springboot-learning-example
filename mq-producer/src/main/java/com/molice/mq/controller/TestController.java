package com.molice.mq.controller;

import com.molice.mq.mapper.BrokerMessageLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author molice
 * @date 2019/4/23
 **/
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private BrokerMessageLogMapper brokerMessageLogMapper;

    @GetMapping("test")
    public Object test() {

        return brokerMessageLogMapper.selectList(null);
    }

}
