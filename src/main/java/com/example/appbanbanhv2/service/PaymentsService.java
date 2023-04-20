package com.example.appbanbanhv2.service;

import com.example.appbanbanhv2.entity.Payments;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface PaymentsService {

    Payments save(Payments payments);

    Optional<Payments> find(Long id);

    List<Payments> findAll();

    List<Payments> findAll(Sort sort);

    Page<Payments> findAll(Pageable pageable);

    void delete(Long id);

    void delete(Payments payments);

    void deleteAll();

    long count();

}