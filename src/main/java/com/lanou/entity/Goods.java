package com.lanou.entity;

import java.util.Date;

/**
 * Created by lanou on 2017/12/4.
 */
public class Goods {
    private Integer goodsId;
    private String goodsName;
    private Double goodsConsultPrice;
    private Double goodsMemberPrice;
    private String goodsSalesMes;
    private Integer goodsInventory;
    private Integer goodsSalesVolume;
    private Integer goodsThirdClassifyId;
    private Date goodsGroundingTime;
    private Integer deleteId;
    private String goodsNum;

    private String img1;
    private String img2;
    private String img3;
    private String img4;

    @Override
    public String toString() {
        return "Goods{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsConsultPrice=" + goodsConsultPrice +
                ", goodsMemberPrice=" + goodsMemberPrice +
                ", goodsSalesMes='" + goodsSalesMes + '\'' +
                ", goodsInventory=" + goodsInventory +
                ", goodsSalesVolume=" + goodsSalesVolume +
                ", goodsThirdClassifyId=" + goodsThirdClassifyId +
                ", goodsGroundingTime=" + goodsGroundingTime +
                ", deleteId=" + deleteId +
                ", goodsNum='" + goodsNum + '\'' +
                ", img1='" + img1 + '\'' +
                ", img2='" + img2 + '\'' +
                ", img3='" + img3 + '\'' +
                ", img4='" + img4 + '\'' +
                '}';
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }

    public String getImg4() {
        return img4;
    }

    public void setImg4(String img4) {
        this.img4 = img4;
    }

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

    public Integer getGoodsSalesVolume() {
        return goodsSalesVolume;
    }

    public void setGoodsSalesVolume(Integer goodsSalesVolume) {
        this.goodsSalesVolume = goodsSalesVolume;
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

    public Goods(Integer goodsSalesVolume) {
        this.goodsSalesVolume = goodsSalesVolume;
    }

    public Goods() {
    }
}
