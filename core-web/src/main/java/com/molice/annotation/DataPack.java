package com.molice.annotation;

import java.lang.annotation.*;

/**
 * 与切面DataPackDecorator一起使用,标准化接口数据传输
 * @ClassName: DataPack 
 * @Description: TODO 
 * @author: molice
 * @date: 2018年8月20日 下午6:06:51
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface DataPack {

}
