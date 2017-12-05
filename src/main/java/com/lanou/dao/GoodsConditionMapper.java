package com.lanou.dao;

import com.lanou.entity.GoodsCondition;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lanou on 2017/12/1.
 */
public interface GoodsConditionMapper {

    public List<GoodsCondition> findAllConditions();

    public List<GoodsCondition> findConditionsByGoods_id(Integer goods_id);

    public List<Integer> getGoodsIdByCondition(@Param("condition_name") String conditionName, @Param("condition_value") String conditionValue,
                                               @Param("goodsIds") List<Integer> goodIds);
}
