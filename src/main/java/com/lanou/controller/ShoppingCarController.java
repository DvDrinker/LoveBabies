package com.lanou.controller;

import com.lanou.entity.ShoppingCar;
import com.lanou.entity.User;
import com.lanou.service.ShoppingCarService;
import com.lanou.util.FastJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by lanou on 2017/12/6.
 */
@Controller
@RequestMapping("/shoppingCar")
public class ShoppingCarController {
    @Autowired
    private ShoppingCarService shoppingCarService;


    @RequestMapping("/addShoppingCar.do")
    public void insertShoppingCar(@RequestParam(required=false,defaultValue="1")Integer goodsCount,
                                  Integer goodsId, @RequestParam(required = false,defaultValue = "0")Integer userId,
                                  HttpServletRequest request , HttpServletResponse response){
        if (userId==0) {
            User user = (User) request.getSession().getAttribute("user");
            userId=user.getUserId();
        }
        int results=shoppingCarService.insertShoppingCar(goodsId,userId,goodsCount);
        boolean result=false;
        if (results==1){
            result=true;
        }
        FastJson.toJson(result,response);
    }

    @RequestMapping("/findShoppingCar.do")
    public void findShoppingCar(@RequestParam(required = false,defaultValue = "0")Integer userId,
                                HttpServletRequest request , HttpServletResponse response){

        if (userId==0) {
            User user = (User) request.getSession().getAttribute("user");
            userId=user.getUserId();
        }
        List<ShoppingCar> shoppingCars=shoppingCarService.findShoppingCar(userId);
        System.out.println("shoppingCar购物车："+shoppingCars);
        FastJson.toJson(shoppingCars,response);
    }


}
