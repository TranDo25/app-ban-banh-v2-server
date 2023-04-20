package com.example.appbanbanhv2.service;


import com.example.appbanbanhv2.entity.Payments;
import com.example.appbanbanhv2.repository.PaymentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentsServiceImpl implements PaymentsService {

    @Autowired
    private PaymentsRepository paymentsRepository;

    @Override
    public Payments save(Payments payments) {
        return paymentsRepository.save(payments);
    }

    @Override
    public Optional<Payments> find(Long id) {
        return paymentsRepository.findById(id);
    }

    @Override
    public List<Payments> findAll() {
        return paymentsRepository.findAll();
    }

    @Override
    public List<Payments> findAll(Sort sort){
        return paymentsRepository.findAll(sort);
    }

    @Override
    public Page<Payments> findAll(Pageable pageable){
        return paymentsRepository.findAll(pageable);
    }

    @Override
    public void delete(Long id) {
    paymentsRepository.deleteById(id);
    }

    @Override
    public void delete(Payments payments) {
        paymentsRepository.delete(payments);
    }

    @Override
    public void deleteAll() {
        paymentsRepository.deleteAll();
    }

    @Override
    public long count() {
        return paymentsRepository.count();
    }

}