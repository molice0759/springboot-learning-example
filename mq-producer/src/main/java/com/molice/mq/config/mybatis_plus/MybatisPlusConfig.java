package com.molice.mq.config.mybatis_plus;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *              ┏┓　　　┏┓
             ┏┛┻━━━┛┻┓
             ┃　　　　　　　┃
             ┃　　　━　　　┃
             ┃　┳┛　┗┳　┃
             ┃　　　　　　　┃
             ┃　　　┻　　　┃
             ┃　　　　　　　┃
             ┗━┓　　　┏━┛
             　　┃　　　┃神兽保佑
             　　┃　　　┃代码无BUG！
             　　┃　　　┗━━━┓
             　　┃　　　　　　　┣┓
             　　┃　　　　　　　┏┛
             　　┗┓┓┏━┳┓┏┛
             　　　┃┫┫　┃┫┫
             　　　┗┻┛　┗┻┛
 * @author molice
 * @date 2019/3/9
 **/
@Configuration
@MapperScan("com.molice.mq.mapper")//将项目中对应的mapper类的路径加进来就可以了
public class MybatisPlusConfig {

    /**
     * 分页插件，自动识别数据库类型
     * @Description: TODO
     * @Author:molice
     * @date 2018年9月14日 上午10:01:50
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}


