package com.molice.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.molice.entity.Order;

/**
 * @author molice
 * @date 2019/4/23
 **/
public class FastJsonConvertUtil {

    /**
     * JSON转对象
     * @param message
     * @param obj
     * @return
     */
    public static Order convertJSONToObject(String message, Object obj){
        Order order = JSON.parseObject(message, new TypeReference<Order>() {});
        return order;
    }

    /**
     * 对象转JSON
     * @param obj
     * @return
     */
    public static String convertObjectToJSON(Object obj){
        String text = JSON.toJSONString(obj);
        return text;
    }
}
