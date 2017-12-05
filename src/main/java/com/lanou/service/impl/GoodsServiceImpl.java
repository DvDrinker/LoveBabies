package com.lanou.service.impl;

import com.lanou.dao.GoodsMapper;
import com.lanou.entity.Goods;
import com.lanou.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

/**
 * Created by lanou on 2017/12/4.
 */
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService{
    @Autowired
    private GoodsMapper goodsMapper;



    @Transactional
    public List<Goods> findGoods() {
        return goodsMapper.findGoods();
    }

    @Transactional
    public List<Goods> findGoodsByClassifyId(List<Integer> integers, Integer sequence) {
        return goodsMapper.findGoodsByClassifyId(integers,sequence);
    }

    public List<Goods> findGoodsByOneClassifyId(List<Integer> integers) {
        return goodsMapper.findGoodsByOneClassifyId(integers);
    }

    @Transactional
    public List<Integer> findGoodsIdByThirdId(List<Integer> thirdIdList) {
        List<Integer> goodsId=goodsMapper.findGoodsIdByThirdId(thirdIdList);
        return goodsId;
    }

    public List<Goods> findGoodsByIdSet(Set<Integer> goodsIds) {
        List<Goods> goods=goodsMapper.findGoodsByIdSet(goodsIds);
        return goods;
    }

    public Goods findGoodsByGoodsId(Integer goodsId) {
        return goodsMapper.findGoodsById(goodsId);
    }

    public List<Goods> findLikeKeyword(String keyword, List<Goods> goodsList) {
        return goodsMapper.findLikeKeyword(keyword,goodsList);
    }


}
