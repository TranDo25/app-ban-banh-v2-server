package com.example.appbanbanhv2.service;

import com.example.appbanbanhv2.entity.Orders;
import com.example.appbanbanhv2.repository.OrdersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public Orders save(Orders orders) {
        return ordersRepository.save(orders);
    }

    @Override
    public Optional<Orders> find(Long id) {
        return ordersRepository.findById(id);
    }

    @Override
    public List<Orders> findAll() {
        return ordersRepository.findAll();
    }

    @Override
    public List<Orders> findAll(Sort sort){
        return ordersRepository.findAll(sort);
    }

    @Override
    public Page<Orders> findAll(Pageable pageable){
        return ordersRepository.findAll(pageable);
    }

    @Override
    public void delete(Long id) {
    ordersRepository.deleteById(id);
    }

    @Override
    public void delete(Orders orders) {
        ordersRepository.delete(orders);
    }

    @Override
    public void deleteAll() {
        ordersRepository.deleteAll();
    }

    @Override
    public long count() {
        return ordersRepository.count();
    }

}