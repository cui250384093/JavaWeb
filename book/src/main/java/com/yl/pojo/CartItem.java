package com.yl.pojo;

import java.math.BigDecimal;

/**
 * @author candk
 * @Description
 * @date 11/4/21 - 2:39 PM
 */
public class CartItem {
    private Integer id;
    private String name;
    private Integer count;
    private BigDecimal price;

    public CartItem() {
    }

    public CartItem(Integer id, String name, Integer count, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = this.price.multiply(new BigDecimal(this.count));
        return totalPrice;
    }


    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                '}';
    }
}
