package com.yl.service.impl;

import com.yl.pojo.*;

import java.util.List;

/**
 * @author candk
 * @Description
 * @date 11/8/21 - 3:32 PM
 */
public interface OrderService {

    /**
     * 生成订单
     * @param cart
     * @param userId
     * @return
     */
    public String createOrder(Cart cart, Integer userId);

    /**
     * 查看所有订单
     */
    public List<Order> showAllOrders();

    /**
     * 发货（管理员）
     * @param orderId
     */
    public int sendOrder(String orderId);

    /**
     * 查看订单详情（用户、管理员）
     * @param orderId
     */
    public List<OrderItem> showOrderDetail(String orderId);

    /**
     * 查看我的订单（用户、管理员）
     * @param userId
     */
    public List<Order> showMyOrders(Integer userId);

    /**
     * 签收订单
     * @param orderId
     */
    public int receiveOrder(String orderId);
}
