package com.a.JPetStore.persistence;

import com.a.JPetStore.domain.orders.Order;

import java.util.List;

/**
 * @author A
 * Created by IamA#1536 on 2018/12/11 23:16
 */
public interface OrderDAO {
    List<Order> getOrdersByUsername(String username) throws Exception;

    Order getOrder(int orderId) throws Exception;

    void insertOrder(Order order) throws Exception;

    void insertOrderStatus(Order order) throws Exception;
}
