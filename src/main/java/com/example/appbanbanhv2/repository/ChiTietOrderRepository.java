package com.example.appbanbanhv2.repository;

import com.example.appbanbanhv2.entity.ChiTietOrder;

import com.example.appbanbanhv2.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChiTietOrderRepository extends JpaRepository<ChiTietOrder, Long> {
    @Query(value = "SELECT id FROM chi_tiet_order ORDER BY id DESC LIMIT 1;", nativeQuery = true)
    int getTheLastestId();
    @Query(value = "SELECT * FROM chi_tiet_order where chi_tiet_order.orders_id= ?1", nativeQuery = true)
    List<ChiTietOrder> findByOrdersId(Integer id);
}