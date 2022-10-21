package com.carloscastor.ordermanager.controller;

import com.carloscastor.ordermanager.dto.OrderDTO;
import com.carloscastor.ordermanager.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDTO createOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.create(orderDTO);
    }

    @GetMapping("/{order-id}")
    public OrderDTO retrieveOrder(@PathVariable("order=id") Integer orderId) {
        return orderService.findByID(orderId);
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
