package com.example.appbanbanhv2.service;

import com.example.appbanbanhv2.entity.Category;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Category save(Category category);

    Optional<Category> find(Long id);

    List<Category> findAll();

    List<Category> findAll(Sort sort);

    Page<Category> findAll(Pageable pageable);

    void delete(Long id);

    void delete(Category category);

    void deleteAll();

    long count();



}