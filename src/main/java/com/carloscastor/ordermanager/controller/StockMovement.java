package com.carloscastor.ordermanager.controller;

import com.carloscastor.ordermanager.dto.StockMovementDTO;

public interface StockMovement {

    void createStockMovement(StockMovementDTO StockMovement);
    StockMovementDTO retrieveStockMovement(Integer StockMovementId);
    void updateStockMovement(Integer StockMovementId, StockMovementDTO StockMovement);
    void deleteStockMovement(Integer StockMovementId);
}
