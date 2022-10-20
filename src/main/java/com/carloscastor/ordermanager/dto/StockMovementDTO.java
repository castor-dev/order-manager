package com.carloscastor.ordermanager.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class StockMovementDTO {

    private Integer id;
    @NotNull
    private ItemQuantityDTO itemQuantity;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date creationDate;
}
