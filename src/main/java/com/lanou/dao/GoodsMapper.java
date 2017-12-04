package com.lanou.dao;

import com.lanou.entity.Goods;

import java.util.List;

/**
 * Created by lanou on 2017/12/4.
 */
public interface GoodsMapper {
    public List<Goods> findGoods();

}
