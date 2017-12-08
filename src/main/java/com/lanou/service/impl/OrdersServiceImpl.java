package com.lanou.service.impl;

import com.lanou.dao.FloorMapper;
import com.lanou.dao.OrdersMapper;
import com.lanou.entity.Floor;
import com.lanou.entity.OrderGoods;
import com.lanou.entity.Orders;
import com.lanou.entity.User;
import com.lanou.service.FloorService;
import com.lanou.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lanou on 2017/12/2.
 */
@Service("ordersService")
public class OrdersServiceImpl implements OrdersService{
    @Autowired
    private OrdersMapper ordersMapper;


    public List<Orders> findorders(User user) {
        List<Orders> orderss= ordersMapper.selectOrders(user);
        return orderss;
    }

    public Integer addOrders(Orders orders) {
         Integer a = ordersMapper.addOrders(orders);

        System.out.println("订单号"+a);
        return a;
    }


    public boolean addOrderGoods(List<OrderGoods> orderGoodss) {
        boolean result = false;
        Integer a = ordersMapper.addOrderGoods(orderGoodss);
        System.out.println("a"+a);
        if (a!=0){
            result = true;
            return result;
        }
        return result;
    }

    public boolean updateOrderId() {
        return false;
    }

    public boolean updateAddressId(Orders orders) {
        boolean result = false;
        Integer a = ordersMapper.updateAddressId(orders);
        if (a!=0){
            result = true;
            return result;
        }
        return result;
    }
}
