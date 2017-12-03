package com.lanou.dao;

import com.lanou.entity.GoodsCondition;

import java.util.List;

/**
 * Created by lanou on 2017/12/1.
 */
public interface GoodsConditionMapper {

    public List<GoodsCondition> findAllConditions();

    public List<GoodsCondition> findConditionsByGoods_id(Integer goods_id);
}
