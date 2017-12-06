package com.lanou.controller;

import com.lanou.entity.ShoppingAddress;
import com.lanou.service.ShoppingAddressService;
import com.lanou.util.FastJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by lanou on 2017/12/5.
 */
@Controller
@RequestMapping("/shoppingAddress")
public class ShoppingAddressController {
    @Autowired
    private ShoppingAddressService shoppingAddressService;
    @RequestMapping("/select.do")
    public void selectAddress(ShoppingAddress shoppingAddress, HttpServletResponse response) {
       List<ShoppingAddress> shoppingAddresses = shoppingAddressService.selectAddress(shoppingAddress);
        FastJson.toJson(shoppingAddresses , response);
    }
    @RequestMapping("/update.do")
    public void updateAddress(ShoppingAddress shoppingAddress,HttpServletResponse response) {
        boolean result = shoppingAddressService.updateAddress(shoppingAddress);
        FastJson.toJson(result,response );
    }
    @RequestMapping("/delete.do")
    public void deleteAddress(ShoppingAddress shoppingAddress,HttpServletResponse response) {
        boolean result = shoppingAddressService.deleteAddress(shoppingAddress);
        FastJson.toJson(result,response);


    }
    @RequestMapping("/add.do")
    public void addAddress(ShoppingAddress shoppingAddress , HttpServletResponse response) {
        System.out.println(shoppingAddress);
      boolean result = shoppingAddressService.addAddress(shoppingAddress);
      FastJson.toJson(result,response);
    }
    @RequestMapping("/default.do")
    public void defaultAddress(ShoppingAddress shoppingAddress , HttpServletResponse response) {
        System.out.println(shoppingAddress);
      boolean result = shoppingAddressService.defaultAddress1(shoppingAddress);
      FastJson.toJson(result,response);
    }


}
