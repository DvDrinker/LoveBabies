package com.lanou.entity;

import java.util.List;

/**
 * Created by lanou on 2017/12/7.
 */
public class OrderGoods {
    private Integer goodsId;
    private Integer order_id;
    private Integer goodsCount;
    private List<Goods> goods;

    @Override
    public String toString() {
        return "OrderGoods{" +
                "goodsId=" + goodsId +
                ", order_id=" + order_id +
                ", goodsCount=" + goodsCount +
                ", goods=" + goods +
                '}';
    }

    public OrderGoods() {
        super();
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }
}
