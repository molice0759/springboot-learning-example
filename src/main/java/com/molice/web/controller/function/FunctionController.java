package com.molice.web.controller.function;

import com.molice.annotation.DataPack;
import com.molice.entity.Tuser;
import com.molice.service.RedisCacheService;
import com.molice.service.TuserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author molice
 * @date 2019/4/10
 **/
@RestController
@RequestMapping("function")
@Api(tags = "函数式接口")
public class FunctionController {

    @Autowired
    private RedisCacheService redisCacheService;
    @Autowired
    private TuserService tuserService;

    @GetMapping("test")
    @DataPack
    @ApiOperation("测试")
    public Object test() {
        List<Tuser> tusers = redisCacheService.findCache("test", 60, () -> tuserService.getList());
        return tusers;
    }
}
