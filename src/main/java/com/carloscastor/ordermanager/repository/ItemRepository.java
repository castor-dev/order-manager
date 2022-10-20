package com.carloscastor.ordermanager.repository;

import com.carloscastor.ordermanager.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {
}
