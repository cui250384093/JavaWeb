package com.yl.dao.impl;

import com.yl.pojo.OrderItem;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author candk
 * @Description
 * @date 11/10/21 - 11:49 AM
 */
class OrderItemDaoImplTest {

    @Test
    void saveOrderItem() {
        OrderItemDaoImpl orderItemDao = new OrderItemDaoImpl();
        orderItemDao.saveOrderItem(new OrderItem(1, "234", 22, new BigDecimal(100.0), new BigDecimal(200.0), "123"));

    }

    @Test
    void queryOrderItemByOrderId() {
        OrderItemDaoImpl orderItemDao = new OrderItemDaoImpl();
        List<OrderItem> orderItems = orderItemDao.queryOrderItemByOrderId("123");
        System.out.println(orderItems);
    }
}