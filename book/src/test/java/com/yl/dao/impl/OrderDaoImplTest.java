package com.yl.dao.impl;

import com.yl.pojo.Order;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author candk
 * @Description
 * @date 11/10/21 - 10:59 AM
 */
class OrderDaoImplTest {

    @Test
    void saveOrder() {
        OrderDaoImpl orderDao = new OrderDaoImpl();

        String orderId = System.currentTimeMillis() + "";
        Order order = new Order("1234", LocalDateTime.now(), new BigDecimal(100), 0, 1);
        orderDao.saveOrder(order);
    }

    @Test
    void queryOrders() {
        OrderDaoImpl orderDao = new OrderDaoImpl();
        List<Order> orders = orderDao.queryOrders();
        System.out.println(orders);

    }

    @Test
    void changeOrderStatus() {
        OrderDaoImpl orderDao = new OrderDaoImpl();
        orderDao.changeOrderStatus("1234", 1);
    }

    @Test
    void queryOrderByUserId() {
        OrderDaoImpl orderDao = new OrderDaoImpl();
        List<Order> orders = orderDao.queryOrderByUserId(1);
        System.out.println(orders);
    }
}