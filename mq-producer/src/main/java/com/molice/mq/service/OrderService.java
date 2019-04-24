package com.molice.mq.service;

import com.molice.entity.BrokerMessageLog;
import com.molice.entity.Order;
import com.molice.mq.constant.Constans;
import com.molice.mq.mapper.BrokerMessageLogMapper;
import com.molice.mq.mapper.OrderMapper;
import com.molice.mq.producer.RabbitOrderSender;
import com.molice.utils.FastJsonConvertUtil;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author molice
 * @date 2019/4/23
 **/
@Service
public class OrderService {

    private static Logger logger = LoggerFactory.getLogger(OrderService.class);
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private BrokerMessageLogMapper brokerMessageLogMapper;

    @Autowired
    private RabbitOrderSender rabbitOrderSender;

    public void createOrder(Order order) {
        try {
            // 使用当前时间当做订单创建时间（为了模拟一下简化）
            Date orderTime = new Date();
            // 插入业务数据
            orderMapper.insert(order);
            // 插入消息记录表数据
            BrokerMessageLog brokerMessageLog = new BrokerMessageLog();
            // 消息唯一ID
            brokerMessageLog.setMessageId(order.getMessageId());
            // 保存消息整体 转为JSON 格式存储入库
            brokerMessageLog.setMessage(FastJsonConvertUtil.convertObjectToJSON(order));
            // 设置消息状态为0 表示发送中
            brokerMessageLog.setStatus("0");
            // 设置消息未确认超时时间窗口为 一分钟
            brokerMessageLog.setNextRetry(DateUtils.addMinutes(orderTime, Constans.ORDER_TIMEOUT));
            brokerMessageLog.setCreateTime(new Date());
            brokerMessageLog.setUpdateTime(new Date());
            brokerMessageLogMapper.insert(brokerMessageLog);
            // 发送消息
            rabbitOrderSender.sendOrder(order);
        } catch (Exception e) {
            logger.error("订单业务异常{}", e);
        }
    }
}
