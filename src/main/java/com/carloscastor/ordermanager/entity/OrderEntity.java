package com.carloscastor.ordermanager.entity;

import com.carloscastor.ordermanager.common.OrderStatus;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "app_order")
public class OrderEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "created_by")
    private UserEntity createdBy;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private ItemEntity orderItem;

    @Column
    private Integer orderItemQuantity;

    @Column
    private LocalDateTime creationDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    public OrderEntity() {
    }

    public OrderEntity(Integer id, UserEntity createdBy, ItemEntity orderItem, Integer orderItemQuantity, LocalDateTime creationDate) {
        super(id);
        this.createdBy = createdBy;
        this.orderItem = orderItem;
        this.orderItemQuantity = orderItemQuantity;
        this.creationDate = creationDate;
    }

    public UserEntity getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(UserEntity createdBy) {
        this.createdBy = createdBy;
    }

    public ItemEntity getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(ItemEntity orderItem) {
        this.orderItem = orderItem;
    }

    public Integer getOrderItemQuantity() {
        return orderItemQuantity;
    }

    public void setOrderItemQuantity(Integer orderItemQuantity) {
        this.orderItemQuantity = orderItemQuantity;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
