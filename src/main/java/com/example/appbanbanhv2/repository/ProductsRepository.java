package com.example.appbanbanhv2.repository;

import com.example.appbanbanhv2.dto.ProductWithImageDTO;
import com.example.appbanbanhv2.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProductsRepository extends JpaRepository<Products, Integer> {

    @Query( value = "SELECT * FROM products ORDER BY so_vote DESC LIMIT 3", nativeQuery = true)
    List<Products> find10product();
    @Query(value = "SELECT id FROM products ORDER BY id DESC LIMIT 1", nativeQuery = true)
    long getNewestProductId();


}