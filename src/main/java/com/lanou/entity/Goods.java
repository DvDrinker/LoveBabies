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

    private String img1_l;
    private String img1_b;
    private String img2_l;
    private String img2_b;
    private String img3_l;
    private String img3_b;
    private String img4_l;

    public String getImg1_l() {
        return img1_l;
    }

    public void setImg1_l(String img1_l) {
        this.img1_l = img1_l;
    }

    public String getImg1_b() {
        return img1_b;
    }

    public void setImg1_b(String img1_b) {
        this.img1_b = img1_b;
    }

    public String getImg2_l() {
        return img2_l;
    }

    public void setImg2_l(String img2_l) {
        this.img2_l = img2_l;
    }

    public String getImg2_b() {
        return img2_b;
    }

    public void setImg2_b(String img2_b) {
        this.img2_b = img2_b;
    }

    public String getImg3_l() {
        return img3_l;
    }

    public void setImg3_l(String img3_l) {
        this.img3_l = img3_l;
    }

    public String getImg3_b() {
        return img3_b;
    }

    public void setImg3_b(String img3_b) {
        this.img3_b = img3_b;
    }

    public String getImg4_l() {
        return img4_l;
    }

    public void setImg4_l(String img4_l) {
        this.img4_l = img4_l;
    }

    public String getImg4_b() {
        return img4_b;
    }

    public void setImg4_b(String img4_b) {
        this.img4_b = img4_b;
    }

    private String img4_b;

    private String introductionImg1;

    public String getIntroductionImg1() {
        return introductionImg1;
    }

    public void setIntroductionImg1(String introductionImg1) {
        this.introductionImg1 = introductionImg1;
    }

    public String getIntroductionImg2() {
        return introductionImg2;
    }

    public void setIntroductionImg2(String introductionImg2) {
        this.introductionImg2 = introductionImg2;
    }

    public String getIntroductionImg3() {
        return introductionImg3;
    }

    public void setIntroductionImg3(String introductionImg3) {
        this.introductionImg3 = introductionImg3;
    }

    private String introductionImg2;

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
                ", img1_l='" + img1_l + '\'' +
                ", img1_b='" + img1_b + '\'' +
                ", img2_l='" + img2_l + '\'' +
                ", img2_b='" + img2_b + '\'' +
                ", img3_l='" + img3_l + '\'' +
                ", img3_b='" + img3_b + '\'' +
                ", img4_l='" + img4_l + '\'' +
                ", img4_b='" + img4_b + '\'' +
                ", introductionImg1='" + introductionImg1 + '\'' +
                ", introductionImg2='" + introductionImg2 + '\'' +
                ", introductionImg3='" + introductionImg3 + '\'' +
                '}';
    }

    private String introductionImg3;


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
