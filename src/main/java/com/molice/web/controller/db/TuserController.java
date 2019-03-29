package com.molice.web.controller.db;


import com.molice.annotation.DataPack;
import com.molice.entity.Tuser;
import com.molice.service.TuserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author molice
 * @since 2019-03-09
 */
@RestController
@RequestMapping("/tuser")
@Api("用户")
public class TuserController {

    @Resource
    private TuserService tuserService;

    @GetMapping("getList")
    @ApiOperation("获取列表")
    @DataPack
    public Object getList() {
        List<Tuser> list = tuserService.getList();
        return list;

    }

}

