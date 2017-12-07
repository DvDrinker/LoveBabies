package com.lanou.dao;

import com.lanou.entity.Goods;
import com.lanou.entity.GoodsCondition;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lanou on 2017/12/1.
 */
public interface GoodsConditionMapper {

    public List<GoodsCondition> findAllConditions();

    public List<GoodsCondition> findConditionsByGoods_id(Integer goods_id);

    public List<Integer> getGoodsIdByCondition(@Param("condition") GoodsCondition goodsCondition,@Param("goodsList") List<Goods> goodss);
}
