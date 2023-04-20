package com.example.appbanbanhv2.service;


import com.example.appbanbanhv2.entity.ChiTietOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface ChiTietOrderService {

    ChiTietOrder save(ChiTietOrder chitietorder);

    Optional<ChiTietOrder> find(Long id);

    List<ChiTietOrder> findAll();

    List<ChiTietOrder> findAll(Sort sort);

    Page<ChiTietOrder> findAll(Pageable pageable);

    void delete(Long id);

    void delete(ChiTietOrder chitietorder);

    void deleteAll();

    long count();

}