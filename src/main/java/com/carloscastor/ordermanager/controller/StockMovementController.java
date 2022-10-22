package com.carloscastor.ordermanager.controller;

import com.carloscastor.ordermanager.dto.OrderStockMovementDTO;
import com.carloscastor.ordermanager.dto.StockMovementDTO;
import com.carloscastor.ordermanager.service.OrderStockReportService;
import com.carloscastor.ordermanager.service.StockMovementService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock-movements")
public class StockMovementController {

    private StockMovementService stockMovementService;
    private OrderStockReportService orderStockReportService;


    public StockMovementController(StockMovementService stockMovementService, OrderStockReportService orderStockReportService) {
        this.stockMovementService = stockMovementService;
        this.orderStockReportService = orderStockReportService;
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

    @GetMapping
    public List<StockMovementDTO> retrieveAllStockMovements(){
        return  stockMovementService.findAll();
    }
    @GetMapping("/{stock-movement-id}/orders")
    public List<OrderStockMovementDTO> retrieveOrderStockMovementsReport(@PathVariable("stock-movement-id") Integer stockMovementId) {
        return orderStockReportService.findBySockMovementId(stockMovementId);
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
