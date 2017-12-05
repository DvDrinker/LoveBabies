package com.lanou.entity;

/**
 * Created by lanou on 2017/12/4.
 */
public class Brand {

    private Integer brandId;
    private String brandName;
    private String brandSrc;
    private Integer classifyId;
    private Integer deleteId;

    public Brand() {
    }

    @Override
    public String toString() {
        return "Brand{" +
                "brandId=" + brandId +
                ", brandName='" + brandName + '\'' +
                ", brandSrc='" + brandSrc + '\'' +
                ", classifyId=" + classifyId +
                ", deleteId=" + deleteId +
                '}';
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandSrc() {
        return brandSrc;
    }

    public void setBrandSrc(String brandSrc) {
        this.brandSrc = brandSrc;
    }

    public Integer getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(Integer classifyId) {
        this.classifyId = classifyId;
    }

    public Integer getDeleteId() {
        return deleteId;
    }

    public void setDeleteId(Integer deleteId) {
        this.deleteId = deleteId;
    }
}
