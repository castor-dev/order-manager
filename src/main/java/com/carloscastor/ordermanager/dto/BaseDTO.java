package com.carloscastor.ordermanager.dto;

public abstract class BaseDTO {

    private Integer id;

    public BaseDTO() {
    }

    protected BaseDTO(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
