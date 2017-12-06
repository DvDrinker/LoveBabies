package com.lanou.entity;

/**
 * Created by lanou on 2017/12/5.
 */
public class DiscountMes {

    private Integer discountId;

    private Goods goods;

    private Integer discountNum;

    private Double discountMoney;

    private Integer deleteId;

    public Integer getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Integer discountId) {
        this.discountId = discountId;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Integer getDiscountNum() {
        return discountNum;
    }

    public void setDiscountNum(Integer discountNum) {
        this.discountNum = discountNum;
    }

    public Double getDiscountMoney() {
        return discountMoney;
    }

    public void setDiscountMoney(Double discountMoney) {
        this.discountMoney = discountMoney;
    }

    public Integer getDeleteId() {
        return deleteId;
    }

    public void setDeleteId(Integer deleteId) {
        this.deleteId = deleteId;
    }

    @Override
    public String toString() {
        return "DiscountMes{" +
                "discountId=" + discountId +
                ", goods=" + goods +
                ", discountNum=" + discountNum +
                ", discountMoney=" + discountMoney +
                ", deleteId=" + deleteId +
                '}';
    }

    public DiscountMes() {
    }
}
