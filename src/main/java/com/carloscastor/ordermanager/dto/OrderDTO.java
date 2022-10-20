package com.carloscastor.ordermanager.dto;

import com.carloscastor.ordermanager.common.OrderStatus;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class OrderDTO {

    private Integer id;
    @NotNull
    private ItemQuantityDTO itemQuantity;
    private OrderStatus status;
    @NotNull
    private Integer createdBy;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date creationDate;

    public OrderDTO() {
    }

    public OrderDTO(Integer id, ItemQuantityDTO itemQuantity, OrderStatus status, Integer createdBy, Date creationDate) {
        this.id = id;
        this.itemQuantity = itemQuantity;
        this.status = status;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ItemQuantityDTO getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(ItemQuantityDTO itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
