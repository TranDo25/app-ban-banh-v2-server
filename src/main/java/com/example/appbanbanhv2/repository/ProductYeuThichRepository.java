package com.example.appbanbanhv2.repository;


import com.example.appbanbanhv2.entity.ProductYeuThich;
import com.example.appbanbanhv2.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface ProductYeuThichRepository extends JpaRepository<ProductYeuThich, Long> {
    @Query(value = "SELECT * FROM product_yeu_thich where product_yeu_thich.id_product = ?1 and product_yeu_thich.users_id = ?2",nativeQuery = true)
    Optional<ProductYeuThich> findProductYeuThichByIdProductAndUsersId(Integer product_id, String users_id);
    @Query(value = "select id_product from product_yeu_thich where product_yeu_thich.users_id = ?1",nativeQuery = true)
    List<Integer> getAllIdProductYeuThichByUserId(String userId);
    @Query(value = "SELECT id FROM product_yeu_thich ORDER BY id DESC LIMIT 1", nativeQuery = true)
    int getTheNewestId();

}