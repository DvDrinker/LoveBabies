package com.lanou.service.impl;

import com.lanou.dao.GoodsConditionMapper;
import com.lanou.entity.GoodsCondition;
import com.lanou.service.GoodsConditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lanou on 2017/12/1.
 */
@Service("GoodsConditionService")
public class GoodsConditionServiceImpl implements GoodsConditionService{

    @Autowired
    private GoodsConditionMapper goodsConditionMapper;


    public List<GoodsCondition> findConditions() {

        return goodsConditionMapper.findAllConditions();
    }

    public List<GoodsCondition> findConditionsByGoods_id(Integer goods_id) {
        return goodsConditionMapper.findConditionsByGoods_id(goods_id);
    }
}
