package com.bw.dao;

import com.bw.entity.Order;

import java.util.List;

public interface OrderDao {
    List<Order> getAllOrder();

    List<Order> getOrderIf(Order order);
}
