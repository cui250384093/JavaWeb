package com.yl.service.impl;

import com.yl.pojo.Cart;
import com.yl.pojo.CartItem;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * @author candk
 * @Description
 * @date 11/10/21 - 1:45 PM
 */
class OrderServiceImplTest {

    @Test
    void createOrder() {
        OrderService orderService = new OrderServiceImpl();
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "java", 10, new BigDecimal(100.0)));
        cart.addItem(new CartItem(2, "java", 10, new BigDecimal(100.0)));
        cart.addItem(new CartItem(2, "java", 10, new BigDecimal(100.0)));

        System.out.println(orderService.createOrder(cart, 1));
    }

    @Test
    void showAllOrders() {
        OrderService orderService = new OrderServiceImpl();
        System.out.println(orderService.showAllOrders());
    }

    @Test
    void sendOrder() {
        OrderService orderService = new OrderServiceImpl();
        orderService.sendOrder("Wed Nov 10 13:47:57 CST 20211");
    }

    @Test
    void showOrderDetail() {
        OrderService orderService = new OrderServiceImpl();
        System.out.println(orderService.showOrderDetail("Wed Nov 10 13:47:57 CST 20211"));
    }

    @Test
    void showMyOrder() {
        OrderService orderService = new OrderServiceImpl();
        System.out.println(orderService.showMyOrders(1));
    }

    @Test
    void receiveOrder() {
        OrderService orderService = new OrderServiceImpl();
        orderService.receiveOrder("Wed Nov 10 13:47:57 CST 20211");
    }
}