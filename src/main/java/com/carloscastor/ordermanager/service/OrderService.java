package com.carloscastor.ordermanager.service;

import com.carloscastor.ordermanager.dto.OrderDTO;
import com.carloscastor.ordermanager.entity.OrderEntity;
import com.carloscastor.ordermanager.mapper.Mapper;
import com.carloscastor.ordermanager.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends AbstractCRUDService<OrderEntity, OrderDTO, Integer, OrderRepository> {

    public OrderService(OrderRepository orderRepository, Mapper<OrderDTO, OrderEntity> mapper) {
        super(orderRepository, mapper);
    }
}
