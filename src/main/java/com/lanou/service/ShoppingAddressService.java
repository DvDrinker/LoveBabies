package com.lanou.service;

import com.lanou.entity.ShoppingAddress;

import java.util.List;

/**
 * Created by lanou on 2017/12/5.
 */
public interface ShoppingAddressService {
    public List<ShoppingAddress> selectAddress(ShoppingAddress shoppingAddress);
    public ShoppingAddress selectAddress1(ShoppingAddress shoppingAddress);
    public boolean updateAddress(ShoppingAddress shoppingAddress);
    public boolean deleteAddress(ShoppingAddress shoppingAddress);
    public boolean addAddress(ShoppingAddress shoppingAddress);
    public boolean defaultAddress1(ShoppingAddress shoppingAddress);


}
