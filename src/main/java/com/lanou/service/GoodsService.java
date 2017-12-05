package com.lanou.service;

import com.lanou.entity.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * Created by lanou on 2017/12/4.
 */
public interface GoodsService {
    public List<Goods> findGoods();

    //根据3级分类查找该分类下的所有商品
    public List<Goods> findGoodsByClassifyId(List<Integer> integers,Integer sequence);

    public List<Integer> findGoodsIdByThirdId(List<Integer> thirdIdList);

    public List<Goods> findGoodsByIdSet(Set<Integer> goodsIds);
}
