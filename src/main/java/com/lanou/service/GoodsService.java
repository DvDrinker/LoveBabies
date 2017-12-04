package com.lanou.service;

import com.lanou.entity.Goods;

import java.util.List;

/**
 * Created by lanou on 2017/12/4.
 */
public interface GoodsService {
    public List<Goods> findGoods();

    public List<Goods> findGoodsByClassifyId(List<Integer> integers);
}
