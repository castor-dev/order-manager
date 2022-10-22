package com.carloscastor.ordermanager.entity;


import javax.persistence.*;

@Entity
@Table(name = "order_stock_movement")
public class OrderStockMovementEntity {


    @EmbeddedId
    private OrderStockId id;
    @Column
    private Integer stockConsumed;
    @Column
    private Integer orderQuantity;

    public OrderStockMovementEntity() {
    }

    public OrderStockMovementEntity(OrderStockId id, Integer stockConsumed, Integer orderQuantity) {
        this.id = id;
        this.stockConsumed = stockConsumed;
        this.orderQuantity = orderQuantity;
    }

    public OrderStockId getId() {
        return id;
    }

    public void setId(OrderStockId id) {
        this.id = id;
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
