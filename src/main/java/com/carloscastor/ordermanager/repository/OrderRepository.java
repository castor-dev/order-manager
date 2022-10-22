package com.carloscastor.ordermanager.repository;

import com.carloscastor.ordermanager.common.OrderStatus;
import com.carloscastor.ordermanager.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
    @Query("SELECT o FROM OrderEntity o where o.orderStatus=:orderStatus order by o.orderItemQuantity, o.creationDate")
    List<OrderEntity> findOrderByStatus(@Param("orderStatus") OrderStatus orderStatus);
}
