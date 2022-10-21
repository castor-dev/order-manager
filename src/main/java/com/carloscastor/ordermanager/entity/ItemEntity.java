package com.carloscastor.ordermanager.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "item")
public class ItemEntity extends BaseEntity{


    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "orderItem")
    private Set<OrderEntity> itemsOrdered;

    @OneToMany(mappedBy = "stockMovementItem")
    private Set<StockMovementEntity> itemsStocked;

    public ItemEntity() {
    }

    public ItemEntity(Integer id, String name) {
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
