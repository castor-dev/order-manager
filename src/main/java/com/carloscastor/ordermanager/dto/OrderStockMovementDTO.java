package com.carloscastor.ordermanager.dto;

public class OrderStockMovementDTO {

    private Integer orderId;
    private Integer stockMovementId;
    private Integer stockConsumed;
    private Integer orderQuantity;

    public OrderStockMovementDTO() {
    }

    public OrderStockMovementDTO(Integer orderId, Integer stockMovementId, Integer stockConsumed, Integer orderQuantity) {
        this.orderId = orderId;
        this.stockMovementId = stockMovementId;
        this.stockConsumed = stockConsumed;
        this.orderQuantity = orderQuantity;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getStockMovementId() {
        return stockMovementId;
    }

    public void setStockMovementId(Integer stockMovementId) {
        this.stockMovementId = stockMovementId;
    }

    public Integer getStockConsumed() {
        return stockConsumed;
    }

    public void setStockConsumed(Integer stockConsumed) {
        this.stockConsumed = stockConsumed;
    }

    public Integer getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(Integer orderQuantity) {
        this.orderQuantity = orderQuantity;
    }
}
