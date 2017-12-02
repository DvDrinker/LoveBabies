package com.lanou.entity;

import java.util.List;

/**
 * Created by lanou on 2017/12/1.
 */
public class Classify {

    private Integer classifyId;
    private String classifyName;
    private Integer classifyBelong;
    private Integer classifyParentId;
    private List<Classify> classifies;
    private Integer deleteId;

    public Integer getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(Integer classifyId) {
        this.classifyId = classifyId;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    public Integer getClassifyBelong() {
        return classifyBelong;
    }

    public void setClassifyBelong(Integer classifyBelong) {
        this.classifyBelong = classifyBelong;
    }

    public Integer getClassifyParentId() {
        return classifyParentId;
    }

    public void setClassifyParentId(Integer classifyParentId) {
        this.classifyParentId = classifyParentId;
    }

    public List<Classify> getClassifies() {
        return classifies;
    }

    public void setClassifies(List<Classify> classifies) {
        this.classifies = classifies;
    }

    public Integer getDeleteId() {
        return deleteId;
    }

    public void setDeleteId(Integer deleteId) {
        this.deleteId = deleteId;
    }

    @Override
    public String toString() {
        return "Classify{" +
                "classifyId=" + classifyId +
                ", classifyName='" + classifyName + '\'' +
                ", classifyBelong=" + classifyBelong +
                ", classifyParentId=" + classifyParentId +
                ", classifies=" + classifies +
                ", deleteId=" + deleteId +
                '}';
    }

    public Classify() {
    }
}
