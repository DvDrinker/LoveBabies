package com.lanou.service.impl;

import com.lanou.dao.GoodsMapper;
import com.lanou.entity.CutPage;
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

    public List<Goods> findGoodsByPrice(Double maxPrice, Double minPrice, List<Goods> goodss) {
        return goodsMapper.findGoodsByPrice(maxPrice,minPrice,goodss);
    }

    public List<Goods> findGoodsBySequence(Integer sequence, List<Goods> goodss) {
        return goodsMapper.findGoodsBySequence(sequence,goodss);
    }

    public List<Goods> limitGoods(CutPage page, List<Goods> goodss) {
        Integer limit1 = (page.getPage()-1)*page.getCOUNT();
        Integer limit2 = (page.getCOUNT());
        return goodsMapper.limitGoods(limit1,limit2,goodss);
    }

    public List<Goods> findGoodsOrderBy(Integer orderBy) {
        List<Goods> goodss=goodsMapper.findGoodsOrderBy(orderBy);
        return goodss;
    }

    public List<Integer> findGoodsThirdClassifyId(String goodsName) {
        List<Integer> thirdClassifyIds=goodsMapper.findGoodsThirdClassifyId(goodsName);
        return thirdClassifyIds;
    }

    public List<Goods> findHotGoodsByClassifyId(List<Integer> classifyId) {
        return goodsMapper.getHotGoodsByClassifyId(classifyId);
    }

    public List<Goods> getGoodsListByIdList(Integer[] goodsIds) {
        return goodsMapper.getGoodsListByIdList(goodsIds);
    }

    public void changeSaleVolumeAndInventory(Integer goodsId, Integer num) {
        goodsMapper.reduceSaleVolume(goodsId,num);
    }


}
