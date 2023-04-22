package com.example.appbanbanhv2.service;

import com.example.appbanbanhv2.entity.ProductYeuThich;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface ProductYeuThichService {

    Optional<ProductYeuThich> findByproduct_idAndUser_id(Integer productId, String userId) ;


    ProductYeuThich save(ProductYeuThich productyeuthich);

    Optional<ProductYeuThich> find(Long id);

    List<ProductYeuThich> findAll();

    List<ProductYeuThich> findAll(Sort sort);

    Page<ProductYeuThich> findAll(Pageable pageable);

    void delete(Long id);

    void delete(ProductYeuThich productyeuthich);

    void deleteAll();

    int count();

}