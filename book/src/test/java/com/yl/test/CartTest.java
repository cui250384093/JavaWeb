package com.yl.test;

import com.yl.pojo.Cart;
import com.yl.pojo.CartItem;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * @author candk
 * @Description
 * @date 11/4/21 - 2:58 PM
 */
class CartTest {

    @Test
    void addItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "java Junior", 1, new BigDecimal(100)));
        cart.addItem(new CartItem(2, "java Middle", 2, new BigDecimal(100)));
        cart.addItem(new CartItem(3, "java Senior", 3, new BigDecimal(100)));

        System.out.println(cart);
    }

    @Test
    void deleteItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "java Junior", 1, new BigDecimal(100)));
        cart.addItem(new CartItem(2, "java Middle", 2, new BigDecimal(100)));
        cart.addItem(new CartItem(3, "java Senior", 3, new BigDecimal(100)));

        cart.deleteItem(1);
        cart.deleteItem(2);
        System.out.println(cart);
    }

    @Test
    void clear() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "java Junior", 1, new BigDecimal(100)));
        cart.addItem(new CartItem(2, "java Middle", 2, new BigDecimal(100)));
        cart.addItem(new CartItem(3, "java Senior", 3, new BigDecimal(100)));

        cart.clear();
        System.out.println(cart);
    }

    @Test
    void updateItemCount() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1, "java Junior", 1, new BigDecimal(100)));
        cart.addItem(new CartItem(2, "java Middle", 2, new BigDecimal(100)));
        cart.addItem(new CartItem(3, "java Senior", 3, new BigDecimal(100)));

        cart.updateItemCount(1, 2);
        System.out.println(cart);
    }
}
