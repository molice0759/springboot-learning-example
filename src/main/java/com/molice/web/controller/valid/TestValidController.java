package com.molice.web.controller.valid;

import com.molice.annotation.DataPack;
import com.molice.vo.School;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author molice
 * @date 2019/3/26
 **/
@RestController
@Api(tags = "valid测试")
@RequestMapping("valid")
public class TestValidController {


    @DataPack
    @ApiOperation("测试")
    @GetMapping("test")
    public Object test(@Validated School school) {
        System.out.println(school.toString());
        return school;
    }
}
