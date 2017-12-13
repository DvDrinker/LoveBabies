package com.lanou.dao;

import com.lanou.entity.OrderGoods;
import com.lanou.entity.Orders;
import com.lanou.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by lanou on 2017/12/7.
 */
public interface OrdersMapper {
    public List<Orders> selectOrders(User user);

    public List<Orders> selectOrdersEveryOne(Orders orders);

    public Orders selectOrdersOne(Orders orders);

    public Integer addOrders(Orders orders);

    public Integer addOrderGoods(@Param("orderGoodss") List<OrderGoods> orderGoodss);

    public Integer updateOrderId();

    public Integer updateBuyId(Orders orders);

    public Integer updateBuyId1(Orders orders);

    public Integer updateAddressId(Orders orders);

    public List<Orders> initialOrders();

    public Integer deleteOrder(@Param("orderId") Integer[] orderId);

}