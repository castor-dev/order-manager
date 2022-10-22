package com.carloscastor.ordermanager.mapper;

import com.carloscastor.ordermanager.dto.OrderStockMovementDTO;
import com.carloscastor.ordermanager.entity.OrderStockId;
import com.carloscastor.ordermanager.entity.OrderStockMovementEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderStockMovementMapper implements Mapper<OrderStockMovementDTO, OrderStockMovementEntity>{
    @Override
    public OrderStockMovementDTO fromEntityToDTO(OrderStockMovementEntity entity) {
        OrderStockMovementDTO dto = new OrderStockMovementDTO();
        dto.setStockConsumed(entity.getStockConsumed());
        dto.setOrderId(entity.getId().getOrderId());
        dto.setStockMovementId(entity.getId().getStockMovementId());
        dto.setOrderQuantity(entity.getOrderQuantity());
        return dto;
    }

    @Override
    public OrderStockMovementEntity fromDTOToEntity(OrderStockMovementDTO orderStockMovementDTO) {
        OrderStockMovementEntity entity = new OrderStockMovementEntity();
        OrderStockId id = new OrderStockId(orderStockMovementDTO.getOrderId(), orderStockMovementDTO.getStockMovementId());
        entity.setId(id);
        entity.setStockConsumed(orderStockMovementDTO.getStockConsumed());
        entity.setOrderQuantity(orderStockMovementDTO.getOrderQuantity());
        return entity;
    }
}
