package com.carloscastor.ordermanager.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "stock_movement")
public class StockMovementEntity extends BaseEntity {

    @Column
    private LocalDateTime creationDate;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private ItemEntity stockMovementItem;

    @Column
    private Integer stockMovementItemQuantity;

    public StockMovementEntity() {
    }

    public StockMovementEntity(Integer id, LocalDateTime creationDate, ItemEntity stockMovementItem, Integer stockMovementItemQuantity) {
        super(id);
        this.creationDate = creationDate;
        this.stockMovementItem = stockMovementItem;
        this.stockMovementItemQuantity = stockMovementItemQuantity;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public ItemEntity getStockMovementItem() {
        return stockMovementItem;
    }

    public void setStockMovementItem(ItemEntity stockMovementItem) {
        this.stockMovementItem = stockMovementItem;
    }

    public Integer getStockMovementItemQuantity() {
        return stockMovementItemQuantity;
    }

    public void setStockMovementItemQuantity(Integer stockMovementItemQuantity) {
        this.stockMovementItemQuantity = stockMovementItemQuantity;
    }
}
