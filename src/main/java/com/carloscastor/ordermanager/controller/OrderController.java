package com.carloscastor.ordermanager.controller;

import com.carloscastor.ordermanager.dto.OrderDTO;

public interface OrderController {

    void createOrder(OrderDTO Order);
    OrderDTO retrieveOrder(Integer OrderId);
    void updateOrder(Integer OrderId, OrderDTO Order);
    void deleteOrder(Integer OrderId);
}
