package com.lanou.entity;

import java.util.List;

/**
 * Created by lanou on 2017/12/6.
 */
public class Orders {
    private Integer orderId;
    private Integer userId;
    private Integer deleteId;
    private Integer addressId;
    private ShoppingAddress shoppingAddress;
    private String mes;
    private double totalPrice; //总价
    private double trueTotalPrice; //应付款
    private double fare; //运费
    private double balance;//返现
    private Integer buyId;

    public Integer getBuyId() {
        return buyId;
    }

    public void setBuyId(Integer buyId) {
        this.buyId = buyId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getTrueTotalPrice() {
        return trueTotalPrice;
    }

    public void setTrueTotalPrice(double trueTotalPrice) {
        this.trueTotalPrice = trueTotalPrice;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    private List<OrderGoods> orderGoods;

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", deleteId=" + deleteId +
                ", addressId=" + addressId +
                ", shoppingAddress=" + shoppingAddress +
                ", mes='" + mes + '\'' +
                ", totalPrice=" + totalPrice +
                ", trueTotalPrice=" + trueTotalPrice +
                ", fare=" + fare +
                ", balance=" + balance +
                ", buyId=" + buyId +
                ", orderGoods=" + orderGoods +
                '}';
    }

    public Orders() {
        super();
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getDeleteId() {
        return deleteId;
    }

    public void setDeleteId(Integer deleteId) {
        this.deleteId = deleteId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public ShoppingAddress getShoppingAddress() {
        return shoppingAddress;
    }

    public void setShoppingAddress(ShoppingAddress shoppingAddress) {
        this.shoppingAddress = shoppingAddress;
    }

    public List<OrderGoods> getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(List<OrderGoods> orderGoods) {
        this.orderGoods = orderGoods;
    }
}
