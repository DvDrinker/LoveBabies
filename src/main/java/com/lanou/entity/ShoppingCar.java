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

    private Integer goodsNum;

    //满减信息

    private User user;

    private Integer delete_id;

    private Double totalPrice;


}
