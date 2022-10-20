package com.carloscastor.ordermanager.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ItemQuantityDTO {

    @NotNull
    private Integer itemId;
    @NotNull
    @Min(1)
    private Integer itemQuantity;


    public ItemQuantityDTO() {
    }

    public ItemQuantityDTO(Integer itemId, Integer itemQuantity) {
        this.itemId = itemId;
        this.itemQuantity = itemQuantity;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(Integer itemQuantity) {
        this.itemQuantity = itemQuantity;
    }
}
