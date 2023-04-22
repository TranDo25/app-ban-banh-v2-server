package com.example.appbanbanhv2.repository;

import com.example.appbanbanhv2.entity.Orders;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
    @Query(value = "SELECT id FROM orders ORDER BY id DESC LIMIT 1;",nativeQuery = true)
    Integer getTheLastestId();
}