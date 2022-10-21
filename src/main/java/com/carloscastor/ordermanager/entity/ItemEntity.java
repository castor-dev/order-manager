package com.carloscastor.ordermanager.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "item")
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "orderItem")
    private Set<OrderEntity> itemsOrdered;

    @OneToMany(mappedBy = "stockMovementItem")
    private Set<StockMovementEntity> itemsStocked;

    public ItemEntity() {
    }

    public ItemEntity(Integer id, String name) {
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
