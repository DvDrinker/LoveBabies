package com.lanou.dao;

import com.lanou.entity.ShoppingAddress;

import java.util.List;

/**
 * Created by lanou on 2017/12/5.
 */
public interface ShoppingAddressMapper {
    public List<ShoppingAddress> selectAddress(ShoppingAddress shoppingAddress);
    public ShoppingAddress selectAddress1(ShoppingAddress shoppingAddress);
    public int updateAddress(ShoppingAddress shoppingAddress);
    public int deleteAddress(ShoppingAddress shoppingAddress);
    public int addAddress(ShoppingAddress shoppingAddress);
    public int defaultAddress1(ShoppingAddress shoppingAddress);
    public int defaultAddress2(ShoppingAddress shoppingAddress);

}
