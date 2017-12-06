package com.lanou.entity;

/**
 * Created by lanou on 2017/12/5.
 */
public class ShoppingCar {
    //该类为购物车类；与订单类区分开
    //购物车有参数为：购物车id（主键）,商品id（使用map映射）,商品数量,满减信息id（使用map映射）,商品信息，用户id（使用map映射）,delete_id,单项合计
    //（单价*数量-满减价格）
    private Integer shoppingCarId;

    private Goods goods;

    private Integer goodsCount;

    private User user;

    private Integer deleteId;

    private Double totalPrice;

    public Integer getShoppingCarId() {
        return shoppingCarId;
    }

    public void setShoppingCarId(Integer shoppingCarId) {
        this.shoppingCarId = shoppingCarId;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getDeleteId() {
        return deleteId;
    }

    public void setDeleteId(Integer deleteId) {
        this.deleteId = deleteId;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "ShoppingCar{" +
                "shoppingCarId=" + shoppingCarId +
                ", goods=" + goods +
                ", goodsCount=" + goodsCount +
                ", user=" + user +
                ", deleteId=" + deleteId +
                ", totalPrice=" + totalPrice +
                '}';
    }

    public ShoppingCar() {
    }
}
