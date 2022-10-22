package com.carloscastor.ordermanager.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OrderStockId implements Serializable {
    private Integer orderId;
    private Integer stockMovementId;

    public OrderStockId() {
    }

    public OrderStockId(Integer orderId, Integer stockMovementId) {
        this.orderId = orderId;
        this.stockMovementId = stockMovementId;
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
}
