package com.carloscastor.ordermanager.service;

import com.carloscastor.ordermanager.dto.StockMovementDTO;
import com.carloscastor.ordermanager.entity.StockMovementEntity;
import com.carloscastor.ordermanager.mapper.Mapper;
import com.carloscastor.ordermanager.repository.StockMovementRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StockMovementService extends AbstractCRUDService<StockMovementEntity, StockMovementDTO, Integer, StockMovementRepository> {

    private static final Logger LOGGER = LoggerFactory.getLogger(StockMovementService.class);
    private OrderService orderService;

    public StockMovementService(StockMovementRepository repository, Mapper<StockMovementDTO, StockMovementEntity> mapper, OrderService orderService) {
        super(repository, mapper);
        this.orderService = orderService;
    }

    @Override
    public StockMovementDTO create(StockMovementDTO dto) {
        dto.setCreationDate(LocalDateTime.now());
        StockMovementDTO stockMovementDTO = super.create(dto);
        LOGGER.info(String.format("Stock movement created at %s, with %s unit of item %s", stockMovementDTO.getCreationDate(), stockMovementDTO.getItemQuantity().getQuantity(), stockMovementDTO.getItemQuantity().getItemId()));
        orderService.processPendingOrders();
        return stockMovementDTO;
    }


}
