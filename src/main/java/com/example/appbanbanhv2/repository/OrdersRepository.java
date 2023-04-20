package com.example.appbanbanhv2.repository;

import com.example.appbanbanhv2.entity.Orders;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
}