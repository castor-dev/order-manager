package com.carloscastor.ordermanager.controller;

import com.carloscastor.ordermanager.dto.StockMovementDTO;
import com.carloscastor.ordermanager.service.StockMovementService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stock-movement")
public class StockMovementController {

    private StockMovementService stockMovementService;

    public StockMovementController(StockMovementService stockMovementService) {
        this.stockMovementService = stockMovementService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StockMovementDTO createStockMovement(@RequestBody StockMovementDTO stockMovementDTO) {
        return stockMovementService.create(stockMovementDTO);
    }

    @GetMapping("/{stock-movement-id}")
    public StockMovementDTO retrieveStockMovement(@PathVariable("stock-movement-id") Integer stockMovementId) {
        return stockMovementService.findByID(stockMovementId);
    }

    @PutMapping("/{stock-movement-id}")
    public StockMovementDTO updateStockMovement(@PathVariable("stock-movement-id") Integer stockMovementId, @RequestBody StockMovementDTO stockMovementDTO) {
        return stockMovementService.update(stockMovementId, stockMovementDTO);
    }

    @DeleteMapping("/{stock-movement-id}")
    public void deleteStockMovement(@PathVariable("stock-movement-id") Integer stockMovementId) {
        stockMovementService.delete(stockMovementId);
    }
}
