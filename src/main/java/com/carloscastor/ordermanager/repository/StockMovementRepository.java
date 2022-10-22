package com.carloscastor.ordermanager.repository;

import com.carloscastor.ordermanager.entity.StockMovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StockMovementRepository extends JpaRepository<StockMovementEntity, Integer> {


    @Query("SELECT sum(sm.stockMovementItemQuantity) from StockMovementEntity sm " +
            "where sm.stockMovementItem.id=:itemId " +
            "group by sm.stockMovementItem")
    Integer getAvailableStock(@Param("itemId") Integer itemId);


    @Query("SELECT sm FROM StockMovementEntity sm where sm.stockMovementItem.id=:itemId " +
            "and sm.stockMovementItemQuantity > 0 " +
            "order by sm.creationDate")
    List<StockMovementEntity> findBAvailableStock(Integer itemId);
}
