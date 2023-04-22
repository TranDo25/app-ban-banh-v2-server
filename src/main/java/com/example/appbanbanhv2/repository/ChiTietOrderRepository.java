package com.example.appbanbanhv2.repository;

import com.example.appbanbanhv2.entity.ChiTietOrder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ChiTietOrderRepository extends JpaRepository<ChiTietOrder, Long> {
    @Query(value = "SELECT id FROM chi_tiet_order ORDER BY id DESC LIMIT 1;", nativeQuery = true)
    int getTheLastestId();
}