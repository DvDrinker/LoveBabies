package com.lanou.service.impl;

import com.lanou.dao.OrdersMapper;
import com.lanou.entity.OrderGoods;
import com.lanou.entity.Orders;
import com.lanou.entity.User;
import com.lanou.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lanou on 2017/12/2.
 */
@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersMapper ordersMapper;


    public List<Orders> findorders(User user) {
        List<Orders> orderss = ordersMapper.selectOrders(user);
        return orderss;
    }

    public List<Orders> selectOrdersEveryOne(Orders orders) {
        List<Orders> orderss = ordersMapper.selectOrdersEveryOne(orders);
        return orderss;
    }

    public Orders findordersOne(Orders orders) {
        Orders orders1 = ordersMapper.selectOrdersOne(orders);

        return orders1;
    }

    public Integer addOrders(Orders orders) {
        Integer a = ordersMapper.addOrders(orders);

        System.out.println("订单号" + a);
        return a;
    }


    public boolean addOrderGoods(List<OrderGoods> orderGoodss) {
        boolean result = false;
        Integer a = ordersMapper.addOrderGoods(orderGoodss);
        System.out.println("a" + a);
        if (a != 0) {
            result = true;
            return result;
        }
        return result;
    }

    public boolean updateOrderId() {
        return false;
    }

    public Integer updateBuyId(Orders orders) {
        Integer a = ordersMapper.updateBuyId(orders);
        return a;
    }

    public Integer updateBuyId1(Orders orders) {
        Integer a = ordersMapper.updateBuyId1(orders);
        return a;
    }

    public boolean updateAddressId(Orders orders) {
        boolean result = false;
        Integer a = ordersMapper.updateAddressId(orders);
        if (a != 0) {
            result = true;
            return result;
        }
        return result;
    }
}
