package com.lanou.entity;

import java.util.List;

/**
 * Created by lanou on 2017/12/5.
 */
public class GoodsConditionList {//这个类是用来接收goodsCondition集合参数的
    private List<GoodsCondition> goodsConditionList;

    public List<GoodsCondition> getGoodsConditionList() {
        return goodsConditionList;
    }

    public void setGoodsConditionList(List<GoodsCondition> goodsConditionList) {
        this.goodsConditionList = goodsConditionList;
    }
}
