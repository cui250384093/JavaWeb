package com.yl.dao.impl;

import com.yl.pojo.Order;

import java.util.List;

/**
 * @author candk
 * @Description
 * @date 11/8/21 - 3:36 PM
 */
public interface OrderDao {

    int saveOrder(Order order);

    List<Order> queryOrders();

    int changeOrderStatus(String orderId, Integer status);

    List<Order> queryOrderByUserId(Integer userId);
}
