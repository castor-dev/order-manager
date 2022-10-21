package com.carloscastor.ordermanager.service;

import com.carloscastor.ordermanager.dto.StockMovementDTO;
import com.carloscastor.ordermanager.entity.StockMovementEntity;
import com.carloscastor.ordermanager.mapper.Mapper;
import com.carloscastor.ordermanager.repository.StockMovementRepository;
import org.springframework.stereotype.Service;

@Service
public class StockMovementService extends AbstractCRUDService<StockMovementEntity, StockMovementDTO, Integer, StockMovementRepository>{
    public StockMovementService(StockMovementRepository repository, Mapper<StockMovementDTO, StockMovementEntity> mapper) {
        super(repository, mapper);
    }


}
