package com.carloscastor.ordermanager.repository;

import com.carloscastor.ordermanager.entity.StockMovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockMovementRepository extends JpaRepository<StockMovementEntity, Integer> {
}
