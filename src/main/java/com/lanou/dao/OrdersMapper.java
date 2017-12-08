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
    public Integer addOrders(Orders orders);
    public Integer addOrderGoods(@Param("orderGoodss") List<OrderGoods> orderGoodss);
    public Integer  updateOrderId();
    public Integer  updateAddressId(Orders orders);
}
