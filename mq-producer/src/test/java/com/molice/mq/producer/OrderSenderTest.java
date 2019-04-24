package com.molice.mq.producer;

import com.molice.entity.Order;
import com.molice.mq.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderSenderTest {

    @Autowired
    private OrderSender orderSender;
    @Autowired
    private OrderService orderService;

    @Test
    public void send() {
        Order order = new Order();
        order.setId(System.currentTimeMillis());
        order.setName("测试订单");
        order.setMessageId(System.currentTimeMillis() + "$" + UUID.randomUUID());
        orderSender.send(order);
    }

    @Test
    public void testCreateOrder() {
        Order order = new Order();
        order.setName("测试订单");
        order.setMessageId(System.currentTimeMillis() + "$" + UUID.randomUUID());
        orderService.createOrder(order);
    }
}