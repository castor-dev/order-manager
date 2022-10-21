package com.carloscastor.ordermanager.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ItemQuantityDTO {

    @NotNull
    private Integer itemId;
    @NotNull
    @Min(1)
    private Integer quantity;


    public ItemQuantityDTO() {
    }

    public ItemQuantityDTO(Integer itemId, Integer itemQuantity) {
        this.itemId = itemId;
        this.quantity = itemQuantity;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
