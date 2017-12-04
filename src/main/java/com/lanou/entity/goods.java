package com.lanou.entity;

import java.util.Date;

/**
 * Created by lanou on 2017/12/4.
 */
public class goods {

    private Integer goodsId;
    private String goodsName;
    private Double goodsConsultPrice;
    private Double goodsMemberPrice;
    private String goodsSalesMes;
    private Integer goodsInventory;
    private Integer goodsSalesVolum;
    private Integer goodsThirdClassifyId;
    private Date goodsGroundingTime;
    private Integer deleteId;
    private String goodsNum;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Double getGoodsConsultPrice() {
        return goodsConsultPrice;
    }

    public void setGoodsConsultPrice(Double goodsConsultPrice) {
        this.goodsConsultPrice = goodsConsultPrice;
    }

    public Double getGoodsMemberPrice() {
        return goodsMemberPrice;
    }

    public void setGoodsMemberPrice(Double goodsMemberPrice) {
        this.goodsMemberPrice = goodsMemberPrice;
    }

    public String getGoodsSalesMes() {
        return goodsSalesMes;
    }

    public void setGoodsSalesMes(String goodsSalesMes) {
        this.goodsSalesMes = goodsSalesMes;
    }

    public Integer getGoodsInventory() {
        return goodsInventory;
    }

    public void setGoodsInventory(Integer goodsInventory) {
        this.goodsInventory = goodsInventory;
    }

    public Integer getGoodsSalesVolum() {
        return goodsSalesVolum;
    }

    public void setGoodsSalesVolum(Integer goodsSalesVolum) {
        this.goodsSalesVolum = goodsSalesVolum;
    }

    public Integer getGoodsThirdClassifyId() {
        return goodsThirdClassifyId;
    }

    public void setGoodsThirdClassifyId(Integer goodsThirdClassifyId) {
        this.goodsThirdClassifyId = goodsThirdClassifyId;
    }

    public Date getGoodsGroundingTime() {
        return goodsGroundingTime;
    }

    public void setGoodsGroundingTime(Date goodsGroundingTime) {
        this.goodsGroundingTime = goodsGroundingTime;
    }

    public Integer getDeleteId() {
        return deleteId;
    }

    public void setDeleteId(Integer deleteId) {
        this.deleteId = deleteId;
    }

    public String getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(String goodsNum) {
        this.goodsNum = goodsNum;
    }

    public goods() {
    }

    @Override
    public String toString() {
        return "goods{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsConsultPrice=" + goodsConsultPrice +
                ", goodsMemberPrice=" + goodsMemberPrice +
                ", goodsSalesMes='" + goodsSalesMes + '\'' +
                ", goodsInventory=" + goodsInventory +
                ", goodsSalesVolum=" + goodsSalesVolum +
                ", goodsThirdClassifyId=" + goodsThirdClassifyId +
                ", goodsGroundingTime=" + goodsGroundingTime +
                ", deleteId=" + deleteId +
                ", goodsNum='" + goodsNum + '\'' +
                '}';
    }
}
