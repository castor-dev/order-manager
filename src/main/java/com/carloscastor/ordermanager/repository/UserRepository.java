package com.carloscastor.ordermanager.repository;

import com.carloscastor.ordermanager.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
