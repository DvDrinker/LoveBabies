package com.lanou.service.impl;

import com.lanou.dao.ShoppingCarMapper;
import com.lanou.entity.ShoppingCar;
import com.lanou.service.ShoppingCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lanou on 2017/12/6.
 */
@Service("shoppingCarService")
public class ShoppingCarServiceImpl implements ShoppingCarService{
    @Autowired
    private ShoppingCarMapper shoppingCarMapper;

    //插入购物车
    public int insertShoppingCar(Integer goodsId, Integer userId,Integer goodsCount) {

        int result=shoppingCarMapper.insertShoppingCar(goodsId,userId,goodsCount);

        return result;
    }

    //查询个人购物车
    public List<ShoppingCar> findShoppingCar(Integer userId) {
        List<ShoppingCar> shoppingCars=shoppingCarMapper.findShoppingCar(userId);
        return shoppingCars;
    }

    public ShoppingCar findShoppingCarByUserIdAndGoodsId(Integer goodsId, Integer userId) {
        ShoppingCar shoppingCar=shoppingCarMapper.findShoppingCarByUserIdAndGoodsId(goodsId,userId);
        return shoppingCar;
    }

    public int updateGoodsCount(Integer goodsId, Integer userId, Integer goodsCount) {
        int number=shoppingCarMapper.updateGoodsCount(goodsId,userId,goodsCount);

        return number;
    }

    public int deleteRecord(List<Integer> shoppingCarIdList) {
        int result=shoppingCarMapper.deleteRecord(shoppingCarIdList);
        return result;
    }
}
