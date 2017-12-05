package com.lanou.entity;

public class Citys {

    private Integer cityId;
    private String  cityName;
    private Integer parentId;

    @Override
    public String toString() {
        return "Citys{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                ", parentId=" + parentId +
                '}';
    }

    public Citys() {
        super();
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}
