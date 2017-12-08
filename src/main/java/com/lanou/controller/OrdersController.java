package com.lanou.controller;

import com.lanou.entity.OrderGoods;
import com.lanou.entity.Orders;
import com.lanou.entity.User;
import com.lanou.service.OrdersService;
import com.lanou.util.FastJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lanou on 2017/12/2.
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;
    @RequestMapping("/findOrders.do")
    public void findorders(User user , HttpServletResponse response){
        List<Orders> orderslist = ordersService.findorders(user);
        FastJson.toJson(orderslist,response);
    }
    @RequestMapping("/addOrderGoods.do")
    public void addOrderGoods(Integer[] goodsId,Integer[] goodsCount,Orders orders,  HttpServletResponse response){
        List<OrderGoods> orderGoodss =new ArrayList<OrderGoods>();
        for (int i = 0; i<goodsCount.length ; i++) {
            OrderGoods orderGoods =new OrderGoods();
            orderGoods.setGoodsId(goodsId[i]);
            orderGoods.setOrder_id(orders.getOrderId());
            orderGoods.setGoodsCount(goodsCount[i]);
            orderGoodss.add(orderGoods);
        }
        System.out.println("jihe:"+orderGoodss);
        boolean res = ordersService.updateAddressId(orders);
     boolean result = ordersService.addOrderGoods(orderGoodss);
        FastJson.toJson(result,response);
    }
    @RequestMapping("/addOrders.do")
    public void addorders(Orders orders , HttpServletResponse response){
        Integer a = ordersService.addOrders(orders);
        int aa = orders.getOrderId();
       if (a==1){
           Map<String, Object> map = new HashMap<String, Object>();
           map.put("orderId" ,aa);
           FastJson.toJson(map,response);
       }else {
           boolean result = false;
           FastJson.toJson( result,response);
       }
    }
}
