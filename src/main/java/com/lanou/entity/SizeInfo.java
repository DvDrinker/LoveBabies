package com.lanou.entity;

/**
 * Created by lanou on 2017/12/8.
 */
public class SizeInfo {
    private Integer sizeId;

    private Integer goodsId;//所属goodsId

    private String  sizeName;//NB X XL//显示在按键上的

    private Integer targetId;//目标goodsId

    private String  context;//文字备注（标题）


    public Integer getSizeId() {
        return sizeId;
    }

    public void setSizeId(Integer sizeId) {
        this.sizeId = sizeId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }



    public Integer getTargetId() {
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public SizeInfo() {
    }

    @Override
    public String toString() {
        return "SizeInfo{" +
                "sizeId=" + sizeId +
                ", goodsId=" + goodsId +
                ", sizeName='" + sizeName + '\'' +
                ", targetId=" + targetId +
                ", context='" + context + '\'' +
                '}';
    }
}
