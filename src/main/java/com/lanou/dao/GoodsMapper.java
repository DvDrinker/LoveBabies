package com.lanou.dao;

import com.lanou.entity.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * Created by lanou on 2017/12/4.
 */
public interface GoodsMapper {
    public List<Goods> findGoods();

    public List<Goods> findGoodsByClassifyId(@Param("items") List<Integer> integers, @Param("seq") Integer sequence);
    //sequence:顺序id;1代表默认顺序;2代表上架时间顺序;3代表销量排序;4代表价格排序

    //排序：上架时间排序；销量排序；价格排序

    public List<Goods> findGoodsByOneClassifyId(@Param("items") List<Integer> integers);

    public List<Integer> findGoodsIdByThirdId(@Param("thirdIdList") List<Integer> thirdIdList);

    public List<Goods> findGoodsByIdSet(@Param("goodsIds")Set<Integer> goodsIds);

    public Goods findGoodsById(Integer goodsId);

    public List<Goods> findLikeKeyword(@Param("keyword") String keyword,@Param("goodsList") List<Goods> goodss);
}
