package com.carloscastor.ordermanager.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "app_user")
public class UserEntity extends BaseEntity {

    @Column
    private String name;

    @Column
    private String email;

    @OneToMany(mappedBy = "createdBy")
    private Set<OrderEntity> userOrders;

    public UserEntity() {
    }

    public UserEntity(Integer id, String name, String email) {
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
