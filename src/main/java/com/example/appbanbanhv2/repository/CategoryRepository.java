package com.example.appbanbanhv2.repository;

import com.example.appbanbanhv2.entity.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = "SELECT id FROM category ORDER BY id DESC LIMIT 1", nativeQuery = true)
    long getNewestCategoryId();
}