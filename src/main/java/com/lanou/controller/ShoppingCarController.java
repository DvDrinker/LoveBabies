package com.lanou.controller;

import com.lanou.entity.ShoppingCar;
import com.lanou.entity.User;
import com.lanou.service.ShoppingCarService;
import com.lanou.util.FastJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
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
        boolean result=false;
        ShoppingCar shoppingCar=shoppingCarService.findShoppingCarByUserIdAndGoodsId(goodsId,userId);
        if (shoppingCar!=null){
            int goodsNum=shoppingCar.getGoodsCount()+1;
            int number=shoppingCarService.updateGoodsCount(goodsId,userId,goodsNum);
            if (number==1){
                result=true;
            }
        }else{
            int results=shoppingCarService.insertShoppingCar(goodsId,userId,goodsCount);
            if (results==1){
                result=true;
            }
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

    @RequestMapping("/updateGoodsCount.do")
    public void updateGoodsCount(Integer goodsCount, Integer goodsId,
                                 @RequestParam(required = false,defaultValue = "0")Integer userId,
                                 HttpServletRequest request , HttpServletResponse response){
        if (userId==0) {
            User user = (User) request.getSession().getAttribute("user");
            userId=user.getUserId();
        }
        boolean result=false;
        int number=shoppingCarService.updateGoodsCount(goodsId,userId,goodsCount);
        if (number==1){
            result=true;
        }
        FastJson.toJson(result,response);
    }

    @RequestMapping("/deleteRecord.do")
    public void deleteShoppingCarRecord(@RequestParam(required = true,value = "shoppingCarIds" ) Integer[] shoppingCarIds, HttpServletResponse response){
        List<Integer> shoppingCarIdList= Arrays.asList(shoppingCarIds);
        int results=shoppingCarService.deleteRecord(shoppingCarIdList);
        System.out.println("results:"+results);
        boolean result=false;
        if (results!=0){
            result=true;
        }
        FastJson.toJson(result,response);
    }

}
