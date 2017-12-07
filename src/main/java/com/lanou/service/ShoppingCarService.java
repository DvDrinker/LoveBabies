package com.lanou.service;

import com.lanou.entity.ShoppingCar;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lanou on 2017/12/6.
 */
public interface ShoppingCarService {

    public int insertShoppingCar(Integer goodsId,Integer userId,Integer goodsCount);

    public List<ShoppingCar> findShoppingCar(Integer userId);

    public ShoppingCar findShoppingCarByUserIdAndGoodsId(Integer goodsId,Integer userId);

    public int updateGoodsCount(Integer goodsId,Integer userId,Integer goodsCount);

    public int deleteRecord(List<Integer> shoppingCarIdList);

}
