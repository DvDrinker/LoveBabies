package com.lanou.dao;

import com.lanou.entity.Goods;

import java.util.List;

/**
 * Created by lanou on 2017/12/4.
 */
public interface GoodsMapper {
    public List<Goods> findGoods();

    public List<Goods> findGoodsByClassifyId(List<Integer> integers,Integer sequence);
    //sequence:顺序id;1代表默认顺序;2代表上架时间顺序;3代表销量排序;4代表价格排序

    //排序：上架时间排序；销量排序；价格排序


}
