package com.carloscastor.ordermanager.controller;

import com.carloscastor.ordermanager.dto.OrderDTO;
import com.carloscastor.ordermanager.dto.OrderStockMovementDTO;
import com.carloscastor.ordermanager.service.OrderService;
import com.carloscastor.ordermanager.service.OrderStockReportService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;
    private OrderStockReportService orderStockReportService;

    public OrderController(OrderService orderService, OrderStockReportService orderStockReportService) {
        this.orderService = orderService;
        this.orderStockReportService = orderStockReportService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDTO createOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.create(orderDTO);
    }

    @GetMapping("/{order-id}")
    public OrderDTO retrieveOrder(@PathVariable("order-id") Integer orderId) {
        return orderService.findByID(orderId);
    }

    @GetMapping("/{order-id}/stock-movements")
    public List<OrderStockMovementDTO> retrieveOrderStockMovementsReport(@PathVariable("order-id") Integer orderId) {
        return orderStockReportService.findByOrderId(orderId);
    }


    @PutMapping("/{order-id}")
    public OrderDTO updateOrder(@PathVariable("order-id") Integer orderId, @RequestBody OrderDTO orderDTO) {
        return orderService.update(orderId, orderDTO);
    }

    @DeleteMapping("/{order-id}")
    public void deleteOrder(Integer orderId) {
        orderService.delete(orderId);
    }
}
