package com.lanou.entity;

/**
 * Created by lanou on 2017/12/2.
 */
public class Floor {

    private Integer floorId;
    private String floorNum;
    private String floorName;
    private Integer classifyId;
    private Integer deleteId;

    @Override
    public String toString() {
        return "Floor{" +
                "floorId=" + floorId +
                ", floorNum='" + floorNum + '\'' +
                ", floorName='" + floorName + '\'' +
                ", classifyId=" + classifyId +
                ", deleteId=" + deleteId +
                '}';
    }

    public Floor() {
    }

    public Integer getFloorId() {
        return floorId;
    }

    public void setFloorId(Integer floorId) {
        this.floorId = floorId;
    }

    public String getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(String floorNum) {
        this.floorNum = floorNum;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
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
