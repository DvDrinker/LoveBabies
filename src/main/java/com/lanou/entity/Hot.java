package com.lanou.entity;

/**
 * Created by lanou on 2017/12/7.
 */
public class Hot {

    private Integer hotId;
    private String hotName;
    private Integer Count;
    private Integer deleteId;

    public Integer getHotId() {
        return hotId;
    }

    public void setHotId(Integer hotId) {
        this.hotId = hotId;
    }

    public String getHotName() {
        return hotName;
    }

    public void setHotName(String hotName) {
        this.hotName = hotName;
    }

    public Integer getCount() {
        return Count;
    }

    public void setCount(Integer count) {
        Count = count;
    }

    public Integer getDeleteId() {
        return deleteId;
    }

    public void setDeleteId(Integer deleteId) {
        this.deleteId = deleteId;
    }

    @Override
    public String toString() {
        return "Hot{" +
                "hotId=" + hotId +
                ", hotName='" + hotName + '\'' +
                ", Count=" + Count +
                ", deleteId=" + deleteId +
                '}';
    }

    public Hot() {
    }
}
