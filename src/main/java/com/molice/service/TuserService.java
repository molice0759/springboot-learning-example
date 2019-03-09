package com.molice.service;

import com.molice.entity.Tuser;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author molice
 * @since 2019-03-09
 */
public interface TuserService extends IService<Tuser> {

    List<Tuser> getList();
}
