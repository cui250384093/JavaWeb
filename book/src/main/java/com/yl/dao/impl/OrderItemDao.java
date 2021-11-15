package com.yl.dao.impl;

import com.yl.pojo.OrderItem;

import java.util.List;

/**
 * @author candk
 * @Description
 * @date 11/8/21 - 3:37 PM
 */
public interface OrderItemDao {

    int saveOrderItem(OrderItem orderItem);

    List<OrderItem> queryOrderItemByOrderId(String orderId);
}
