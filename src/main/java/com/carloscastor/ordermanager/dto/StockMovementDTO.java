package com.carloscastor.ordermanager.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;

public class StockMovementDTO extends BaseDTO {

    @NotNull
    private ItemQuantityDTO itemQuantity;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime creationDate;


    public StockMovementDTO() {
    }

    public StockMovementDTO(Integer id, ItemQuantityDTO itemQuantity, LocalDateTime creationDate) {
        super(id);
        this.itemQuantity = itemQuantity;
        this.creationDate = creationDate;
    }

    public ItemQuantityDTO getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(ItemQuantityDTO itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
