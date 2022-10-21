package com.carloscastor.ordermanager.dto;

import javax.validation.constraints.NotEmpty;

public class ItemDTO extends BaseDTO{

    @NotEmpty
    private String name;

    public ItemDTO() {
        super();
    }

    public ItemDTO(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
