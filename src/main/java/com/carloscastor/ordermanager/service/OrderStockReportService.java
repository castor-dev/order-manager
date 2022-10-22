package com.carloscastor.ordermanager.service;

import com.carloscastor.ordermanager.dto.OrderStockMovementDTO;
import com.carloscastor.ordermanager.entity.OrderStockId;
import com.carloscastor.ordermanager.entity.OrderStockMovementEntity;
import com.carloscastor.ordermanager.mapper.OrderStockMovementMapper;
import com.carloscastor.ordermanager.repository.OrderStockMovementRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderStockReportService {

    private OrderStockMovementRepository repository;
    private OrderStockMovementMapper mapper;

    public OrderStockReportService(OrderStockMovementRepository repository, OrderStockMovementMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public void registerOrderStockConsumption(Integer orderId, Integer stockMovementId, Integer stockMovementItemQuantity, Integer orderQuantity) {
        OrderStockMovementEntity orderStockMovement = new OrderStockMovementEntity();
        OrderStockId orderStockId = new OrderStockId();
        orderStockId.setOrderId(orderId);
        orderStockId.setStockMovementId(stockMovementId);
        orderStockMovement.setId(orderStockId);
        orderStockMovement.setStockConsumed(stockMovementItemQuantity);
        orderStockMovement.setOrderQuantity(orderQuantity);
        repository.save(orderStockMovement);
    }

    public List<OrderStockMovementDTO> findByOrderId(Integer orderId) {
        return repository.findByOrderId(orderId).stream().map(e -> mapper.fromEntityToDTO(e)).collect(Collectors.toList());
    }

    public List<OrderStockMovementDTO> findBySockMovementId(Integer stockMovementId) {
        return repository.findByStockMovementId(stockMovementId).stream().map(e -> mapper.fromEntityToDTO(e)).collect(Collectors.toList());
    }
}
