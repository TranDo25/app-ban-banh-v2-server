package com.example.appbanbanhv2.service;

import com.example.appbanbanhv2.entity.ThanhToanMomo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface ThanhToanMomoService {

    ThanhToanMomo save(ThanhToanMomo thanhtoanmomo);

    Optional<ThanhToanMomo> find(Long id);

    List<ThanhToanMomo> findAll();

    List<ThanhToanMomo> findAll(Sort sort);

    Page<ThanhToanMomo> findAll(Pageable pageable);

    void delete(Long id);

    void delete(ThanhToanMomo thanhtoanmomo);

    void deleteAll();

    long count();

}