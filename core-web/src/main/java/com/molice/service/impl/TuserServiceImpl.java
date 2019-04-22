package com.molice.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.molice.entity.Tuser;
import com.molice.mapper.TuserMapper;
import com.molice.service.TuserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author molice
 * @since 2019-03-09
 */
@Service
public class TuserServiceImpl extends ServiceImpl<TuserMapper, Tuser> implements TuserService {

    @Override
    public List<Tuser> getList() {
        return selectList(new EntityWrapper<>());
    }
}
