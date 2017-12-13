package com.lanou.controller;

import com.lanou.entity.*;
import com.lanou.service.GoodsService;
import com.lanou.service.OrdersService;
import com.lanou.util.FastJson;
import com.lanou.util.LimitPage;
import javafx.scene.shape.Mesh;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by lanou on 2017/12/2.
 */
@Controller
@RequestMapping(value="/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private GoodsService goodsService;
    @RequestMapping(value = "/updateBuyId.do" )
    public void updateBuyId(Orders orders , HttpServletResponse response){
        Map<String, Object> map = new HashMap<String, Object>();
        Integer integer = ordersService.updateBuyId(orders);
        if (integer==1){

            map.put("mes" ,"支付成功");
            FastJson.toJson(map,response);
        }else {
            map.put("mes" ,"支付失败");
            FastJson.toJson(map,response);
        }

    }
    @RequestMapping(value = "/updateBuyId1.do")
    public void updateBuyId1(Orders orders , HttpServletResponse response){
        Map<String, Object> map = new HashMap<String, Object>();
       Integer integer = ordersService.updateBuyId1(orders);
        if (integer==1){
            map.put("mes" ,"订单作废");
            FastJson.toJson(map,response);
        }else {
            map.put("mes" ,"作废失败");
            FastJson.toJson(map,response);
        }
    }
    @RequestMapping(value = "/findOrders.do")
    public void findorders(User user , HttpServletResponse response){
        List<Orders> orderslist = ordersService.findorders(user);
        FastJson.toJson(orderslist,response);
    }
    @RequestMapping(value = "/findOrdersOne.do")
    public void findordersOne(Orders orders, HttpServletResponse response){
       Orders orders1 = ordersService.findordersOne(orders);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("orders",orders1);
        FastJson.toJson(map,response);
    }
    @RequestMapping(value = "/addOrderGoods.do")
    public void addOrderGoods(Integer[] goodsId,Integer[] goodsCount,Orders orders,  HttpServletResponse response){

        List<OrderGoods> orderGoodss =new ArrayList<OrderGoods>();
        List<Integer> sums = new ArrayList<Integer>();
        for (int i = 0; i<goodsCount.length ; i++) {
            Goods goods = goodsService.findGoodsByGoodsId(goodsId[i]);
            int sum = goods.getGoodsInventory()-goodsCount[i];
            if (sum<0){
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("商品id为"+goodsId[i]+"库存为:",goods.getGoodsInventory());
                String mes="库存不足";
                map.put("mes",mes);
                FastJson.toJson(map,response);
                break;

            }
//            -----调皮-----
            Integer a  = goods.getGoodsInventory()-goodsCount[i];
             Integer b = goods.getGoodsSalesVolume()+goodsCount[i];
            System.out.println(a);
            System.out.println(b);

            goodsService.changeSaleVolumeAndInventory(goodsId[i],a,b);
            OrderGoods orderGoods =new OrderGoods();
            orderGoods.setGoodsId(goodsId[i]);
            orderGoods.setOrder_id(orders.getOrderId());
            orderGoods.setGoodsCount(goodsCount[i]);
            orderGoodss.add(orderGoods);

        }
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
//         df.format(new Date());// new Date()为获取当前系统时间
        System.out.println("jihe:"+orderGoodss);
        orders.setStartTime(new Date());
        boolean res = ordersService.updateAddressId(orders);
     boolean result = ordersService.addOrderGoods(orderGoodss);
        FastJson.toJson(result,response);
    }
    @RequestMapping(value = "/addOrders.do")
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

    @RequestMapping(value = "/selectOrdersByOrderId.do")
    public void selectOrdersEveryOne(Orders orders, CutPage cutPage,HttpServletResponse response){
        List<Orders> orderss = ordersService.selectOrdersEveryOne(orders);
        cutPage.setCOUNT(4);
        LimitPage limitPage  =new LimitPage();
        List<Orders> orderss1 = limitPage.limitList(cutPage,orderss);
        int totalPage  =  orderss.size()%cutPage.getCOUNT() == 0
                ? orderss.size()/cutPage.getCOUNT()
                : orderss.size()/cutPage.getCOUNT() + 1 ;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("总页数:", totalPage);
        map.put("第"+cutPage.getPage()+"页:",orderss1);
        FastJson.toJson(map,response);
    }
    @RequestMapping(value = "/initialOrders.do")
    public void initialOrders( CutPage cutPage,HttpServletResponse response){
        List<Orders> orderss = ordersService.initialOrders();
        cutPage.setCOUNT(4);
        LimitPage limitPage  =new LimitPage();
        List<Orders> orderss1 = limitPage.limitList(cutPage,orderss);
        int totalPage  =  orderss.size()%cutPage.getCOUNT() == 0
                ? orderss.size()/cutPage.getCOUNT()
                : orderss.size()/cutPage.getCOUNT() + 1 ;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("总页数:", totalPage);
        map.put("第"+cutPage.getPage()+"页:",orderss1);
        FastJson.toJson(map,response);
    }
    @RequestMapping(value = "deleteOrder.do")
    public  void deleteUser(Integer[] orderId , HttpServletResponse response){
        boolean  result =  ordersService.deleteOrder(orderId);
        FastJson.toJson(result,response);

    }

}
