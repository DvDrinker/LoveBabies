package com.lanou.service.impl;

import com.lanou.dao.ShoppingAddressMapper;
import com.lanou.entity.ShoppingAddress;
import com.lanou.service.ShoppingAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lanou on 2017/12/5.
 */
@Service("/shoppingAddressService")
public class ShoppingAddressServiceImpl implements ShoppingAddressService{
    @Autowired
    private ShoppingAddressMapper shoppingAddressMapper;
    public List<ShoppingAddress> selectAddress(ShoppingAddress shoppingAddress) {
        List<ShoppingAddress> shoppingAddresses = shoppingAddressMapper.selectAddress(shoppingAddress);
        return shoppingAddresses;
    }
    public boolean updateAddress(ShoppingAddress shoppingAddress) {
        boolean result = false;
        int a = shoppingAddressMapper.updateAddress(shoppingAddress);
        if (a==1){
            result=true;
        }
        return result;
    }

    public boolean deleteAddress(ShoppingAddress shoppingAddress) {
        boolean result = false;
        int a = shoppingAddressMapper.deleteAddress(shoppingAddress);
        if (a==1){
            result=true;
        }
        return result;

    }

    public boolean addAddress(ShoppingAddress shoppingAddress) {
        boolean result = false;
        int a = shoppingAddressMapper.addAddress(shoppingAddress);
        if (a==1){
            result=true;
        }
        return result;
    }

    public boolean defaultAddress1(ShoppingAddress shoppingAddress) {
        int a = shoppingAddressMapper.defaultAddress1(shoppingAddress);
        System.out.println("a:"+a);
        if (a>=1){
            int b = shoppingAddressMapper.defaultAddress2(shoppingAddress);
            System.out.println("b:"+b);
             return true;
        }
        return false;
    }


}
