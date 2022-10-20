package com.carloscastor.ordermanager.dto;

import javax.validation.constraints.NotEmpty;

public class ItemDTO {

    private Integer id;
    @NotEmpty
    private String name;

    public ItemDTO() {
    }

    public ItemDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
