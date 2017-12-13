package com.lanou.service;

import com.lanou.entity.Floor;
import com.lanou.entity.OrderGoods;
import com.lanou.entity.Orders;
import com.lanou.entity.User;
import org.springframework.core.annotation.Order;

import java.util.List;

/**
 * Created by lanou on 2017/12/2.
 */
public interface OrdersService {
    public List<Orders> findorders(User user);
    public List<Orders> selectOrdersEveryOne(Orders orders);
    public List<Orders> initialOrders();
    public Orders findordersOne(Orders orders);
    public Integer addOrders(Orders orders);
    public boolean addOrderGoods(List<OrderGoods> orderGoodss);
    public boolean updateOrderId();
    public Integer  updateBuyId(Orders orders);
    public Integer  updateBuyId1(Orders orders);
    public boolean updateAddressId(Orders orders);
    public  boolean deleteOrder(Integer[] orderId);
}
