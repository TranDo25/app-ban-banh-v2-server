package com.example.appbanbanhv2.service;

import com.example.appbanbanhv2.entity.ThanhToanMomo;
import com.example.appbanbanhv2.repository.ThanhToanMomoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@Service
public class ThanhToanMomoServiceImpl implements ThanhToanMomoService {

    @Autowired
    private ThanhToanMomoRepository thanhtoanmomoRepository;

    @Override
    public ThanhToanMomo save(ThanhToanMomo thanhtoanmomo) {
        return thanhtoanmomoRepository.save(thanhtoanmomo);
    }

    @Override
    public Optional<ThanhToanMomo> find(Long id) {
        return thanhtoanmomoRepository.findById(id);
    }

    @Override
    public List<ThanhToanMomo> findAll() {
        return thanhtoanmomoRepository.findAll();
    }

    @Override
    public List<ThanhToanMomo> findAll(Sort sort){
        return thanhtoanmomoRepository.findAll(sort);
    }

    @Override
    public Page<ThanhToanMomo> findAll(Pageable pageable){
        return thanhtoanmomoRepository.findAll(pageable);
    }

    @Override
    public void delete(Long id) {
    thanhtoanmomoRepository.deleteById(id);
    }

    @Override
    public void delete(ThanhToanMomo thanhtoanmomo) {
        thanhtoanmomoRepository.delete(thanhtoanmomo);
    }

    @Override
    public void deleteAll() {
        thanhtoanmomoRepository.deleteAll();
    }

    @Override
    public long count() {
        return thanhtoanmomoRepository.count();
    }

}