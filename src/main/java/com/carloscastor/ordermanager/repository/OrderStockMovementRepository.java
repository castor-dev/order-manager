package com.carloscastor.ordermanager.repository;

import com.carloscastor.ordermanager.entity.OrderStockId;
import com.carloscastor.ordermanager.entity.OrderStockMovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderStockMovementRepository extends JpaRepository<OrderStockMovementEntity, OrderStockId> {

    @Query("SELECT osm from OrderStockMovementEntity osm where osm.id.orderId=:orderId")
    List<OrderStockMovementEntity> findByOrderId(@Param("orderId") Integer orderId);

    @Query("SELECT osm from OrderStockMovementEntity osm where osm.id.stockMovementId=:stockMovementId")
    List<OrderStockMovementEntity> findByStockMovementId(@Param("stockMovementId") Integer stockMovementId);
}
