package com.example.appbanbanhv2.repository;


import com.example.appbanbanhv2.entity.ProductYeuThich;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface ProductYeuThichRepository extends JpaRepository<ProductYeuThich, Long> {
    @Query(value = "SELECT * FROM product_yeu_thich where product_yeu_thich.id_product = ?1 and product_yeu_thich.users_id = ?2",nativeQuery = true)
    Optional<ProductYeuThich> findProductYeuThichByIdProductAndUsersId(Integer product_id, String users_id);
}