package com.lanou.service;

import com.lanou.entity.ShoppingCar;

import java.util.List;

/**
 * Created by lanou on 2017/12/6.
 */
public interface ShoppingCarService {

    public int insertShoppingCar(Integer goodsId,Integer userId,Integer goodsCount);

    public List<ShoppingCar> findShoppingCar(Integer userId);

}
