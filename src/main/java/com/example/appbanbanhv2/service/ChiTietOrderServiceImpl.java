package com.example.appbanbanhv2.service;


import com.example.appbanbanhv2.entity.ChiTietOrder;
import com.example.appbanbanhv2.repository.ChiTietOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@Service
public class ChiTietOrderServiceImpl implements ChiTietOrderService {

    @Autowired
    private ChiTietOrderRepository chitietorderRepository;

    @Override
    public ChiTietOrder save(ChiTietOrder chitietorder) {
        return chitietorderRepository.save(chitietorder);
    }

    @Override
    public Optional<ChiTietOrder> find(Long id) {
        return chitietorderRepository.findById(id);
    }

    @Override
    public List<ChiTietOrder> findAll() {
        return chitietorderRepository.findAll();
    }

    @Override
    public List<ChiTietOrder> findAll(Sort sort){
        return chitietorderRepository.findAll(sort);
    }

    @Override
    public Page<ChiTietOrder> findAll(Pageable pageable){
        return chitietorderRepository.findAll(pageable);
    }

    @Override
    public void delete(Long id) {
    chitietorderRepository.deleteById(id);
    }

    @Override
    public void delete(ChiTietOrder chitietorder) {
        chitietorderRepository.delete(chitietorder);
    }

    @Override
    public void deleteAll() {
        chitietorderRepository.deleteAll();
    }

    @Override
    public long count() {
        return chitietorderRepository.count();
    }

}