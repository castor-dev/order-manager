package com.carloscastor.ordermanager.service;

import com.carloscastor.ordermanager.dto.ItemQuantityDTO;
import com.carloscastor.ordermanager.dto.StockMovementDTO;
import com.carloscastor.ordermanager.entity.StockMovementEntity;
import com.carloscastor.ordermanager.mapper.Mapper;
import com.carloscastor.ordermanager.repository.StockMovementRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockMovementService extends AbstractCRUDService<StockMovementEntity, StockMovementDTO, Integer, StockMovementRepository> {

    private OrderService orderService;

    public StockMovementService(StockMovementRepository repository, Mapper<StockMovementDTO, StockMovementEntity> mapper, OrderService orderService) {
        super(repository, mapper);
        this.orderService = orderService;
    }

    @Override
    public StockMovementDTO create(StockMovementDTO dto) {
        dto.setCreationDate(LocalDateTime.now());
        StockMovementDTO stockMovementDTO = super.create(dto);
        orderService.processPendingOrders();
        return stockMovementDTO;
    }


}
