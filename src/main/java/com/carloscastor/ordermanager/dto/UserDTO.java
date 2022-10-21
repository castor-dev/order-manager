package com.carloscastor.ordermanager.dto;

import org.springframework.lang.NonNull;

import javax.validation.constraints.NotEmpty;

public class UserDTO extends BaseDTO {

    @NotEmpty
    private String name;
    @NotEmpty
    private String email;

    public UserDTO() {
    }

    public UserDTO(Integer id, String name, String email) {
        super(id);
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
