package com.lanou.entity;

import java.util.List;

/**
 * Created by lanou on 2017/12/5.
 */
public class GoodsList {

    private List<Goods> goodsList;

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public GoodsList() {
    }

    @Override
    public String toString() {
        return "GoodsList{" +
                "goodsList=" + goodsList +
                '}';
    }
}
