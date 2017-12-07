package com.lanou.service;

import com.lanou.entity.Goods;
import com.lanou.entity.GoodsCondition;

import java.util.List;

/**
 * Created by lanou on 2017/12/1.
 */
public interface GoodsConditionService {

    public List<GoodsCondition> findConditions();

    public List<GoodsCondition> findConditionsByGoods_id(Integer goods_id);

    public List<Goods> getGoodsIdByCondition(GoodsCondition condition, List<Goods> goodss);
}
