package com.lanou.dao;

import com.lanou.entity.ShoppingCar;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lanou on 2017/12/5.
 */
public interface ShoppingCarMapper {

    public int insertShoppingCar(@Param("goodsId") Integer goodsId,@Param("userId") Integer userId,@Param("goodsCount") Integer goodsCount);

    public List<ShoppingCar> findShoppingCar(@Param("userId") Integer userId);
}
