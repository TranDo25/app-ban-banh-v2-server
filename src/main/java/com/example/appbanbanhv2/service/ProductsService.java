package com.example.appbanbanhv2.service;

import com.example.appbanbanhv2.dto.ProductWithImageDTO;
import com.example.appbanbanhv2.entity.Products;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface ProductsService {

    Products save(Products products);

    Optional<Products> find(Integer id);

    List<Products> findAll();

    List<Products> findAll(Sort sort);

    Page<Products> findAll(Pageable pageable);

    void delete(Integer id);

    void delete(Products products);

    void deleteAll();

    long count();

    List<Products> find10product();

    long getNewestProductId();

    List<ProductWithImageDTO> findAllProductAndItsImage();

	List<ProductWithImageDTO> searchProductByName(String searchString);

	List<ProductWithImageDTO> findAllProductByCategory(int id);

	ProductWithImageDTO getProductWithImageById(int id);
}