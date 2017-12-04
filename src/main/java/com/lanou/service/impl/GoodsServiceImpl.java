package com.lanou.service.impl;

import com.lanou.dao.GoodsMapper;
import com.lanou.entity.Goods;
import com.lanou.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lanou on 2017/12/4.
 */
@Service("GoodsService")
public class GoodsServiceImpl implements GoodsService{
    @Autowired
    private GoodsMapper goodsMapper;

    @Transactional
    public List<Goods> findGoods() {
        return goodsMapper.findGoods();
    }
}
