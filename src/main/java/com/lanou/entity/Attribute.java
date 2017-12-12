package com.lanou.entity;

/**
 * Created by lanou on 2017/12/12.
 */
public class Attribute {
    private Integer aId;//主键

    private Integer goodsId;//商品

    private Integer userId;//用户

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Attribute{" +
                "aId=" + aId +
                ", goodsId=" + goodsId +
                ", userId=" + userId +
                '}';
    }

    public Attribute() {
    }
}
