package com.example.appbanbanhv2.repository;


import com.example.appbanbanhv2.imagemodel.ImageData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StorageRepository extends JpaRepository<ImageData, Long> {
    @Query(value = "select name from image_data where products_id = ?1", nativeQuery = true)
    String getImageNameByIdProduct(long id);

    Optional<ImageData> findByName(String fileName);
}