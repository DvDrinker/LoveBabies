package com.lanou.service;

import com.lanou.entity.CutPage;
import com.lanou.entity.Goods;

import java.util.List;
import java.util.Set;

/**
 * Created by lanou on 2017/12/4.
 */
public interface GoodsService {
    public List<Goods> findGoods();

    //根据3级分类查找该分类下的所有商品
    public List<Goods> findGoodsByClassifyId(List<Integer> integers,Integer sequence);

    public List<Goods> findGoodsByOneClassifyId(List<Integer> integers);

    public List<Integer> findGoodsIdByThirdId(List<Integer> thirdIdList);

    public List<Goods> findGoodsByIdSet(Set<Integer> goodsIds);

    public Goods findGoodsByGoodsId(Integer goodsId);

    public List<Goods> findLikeKeyword(String keyword,List<Goods> goodsList);

    public List<Goods> findGoodsByPrice(Double maxPrice,Double minPrice,List<Goods> goodss);

    public List<Goods> findGoodsBySequence(Integer sequence,List<Goods> goodss);

    public List<Goods> limitGoods(CutPage page,List<Goods> goodss);

    public List<Goods> findGoodsOrderBy(Integer orderBy);

    public List<Integer> findGoodsThirdClassifyId(String goodsName);
}
