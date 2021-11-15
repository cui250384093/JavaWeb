package com.yl.dao.impl;

import com.yl.pojo.OrderItem;

import java.util.List;

/**
 * @author candk
 * @Description
 * @date 11/8/21 - 4:23 PM
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {

    @Override
    public int saveOrderItem(OrderItem orderItem) {


        String sql = "insert into t_order_item(name, count, price, total_money, order_id) values(?, ?, ?, ?, ?)";

        return update(sql, orderItem.getName(), orderItem.getCount(), orderItem.getPrice(), orderItem.getTotalPrice(), orderItem.getOrderId());
    }

    @Override
    public List<OrderItem> queryOrderItemByOrderId(String orderId) {
        String sql = "select id, name, price, total_money totalPrice, count, order_id orderId from t_order_item where order_id=?";

        return queryForList(OrderItem.class, sql, orderId);
    }
}
