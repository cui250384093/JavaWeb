package com.yl.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;


/**
 * @author candk
 * @Description
 * @date 11/8/21 - 10:28 AM
 */
public class Order {

    private String orderId;
    private LocalDateTime createTime;
    private BigDecimal price;

    /**
     * 0未发货，1已发货，2已签收
     */
    private Integer status = 0;
    private Integer userId;

    public Order() {
    }

    public Order(String orderId, LocalDateTime createData, BigDecimal price, Integer status, Integer userId) {
        this.orderId = orderId;
        this.createTime = createData;
        this.price = price;
        this.status = status;
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createData) {
        this.createTime = createData;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", createTime=" + createTime +
                ", price=" + price +
                ", status=" + status +
                ", userId=" + userId +
                '}';
    }
}
