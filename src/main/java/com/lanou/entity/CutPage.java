package com.lanou.entity;

/**
 * Created by lanou on 2017/12/5.
 */
public class CutPage {
    private Integer page;

    public Integer getCOUNT() {
        return COUNT;
    }

    public void setCOUNT(Integer COUNT) {
        this.COUNT = COUNT;
    }

    private Integer COUNT;//每页多少个
    private Integer totalPage;

    public CutPage() {
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }



    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    @Override
    public String toString() {
        return "CutPage{" +
                "page=" + page +
                ", COUNT=" + COUNT +
                ", totalPage=" + totalPage +
                '}';
    }


}
