package com.example.appbanbanhv2.service;

import com.example.appbanbanhv2.entity.ProductYeuThich;
import com.example.appbanbanhv2.repository.ProductYeuThichRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@Service
public class ProductYeuThichServiceImpl implements ProductYeuThichService {

    @Autowired
    private ProductYeuThichRepository productyeuthichRepository;

    @Override
    public Optional<ProductYeuThich> findByproduct_idAndUser_id(Integer productId, String userId) {
        return productyeuthichRepository.findProductYeuThichByIdProductAndUsersId(productId,userId);
    }

    @Override
    public ProductYeuThich save(ProductYeuThich productyeuthich) {
        return productyeuthichRepository.save(productyeuthich);
    }

    @Override
    public Optional<ProductYeuThich> find(Long id) {
        return productyeuthichRepository.findById(id);
    }

    @Override
    public List<ProductYeuThich> findAll() {
        return productyeuthichRepository.findAll();
    }

    @Override
    public List<ProductYeuThich> findAll(Sort sort){
        return productyeuthichRepository.findAll(sort);
    }

    @Override
    public Page<ProductYeuThich> findAll(Pageable pageable){
        return productyeuthichRepository.findAll(pageable);
    }

    @Override
    public void delete(Long id) {
    productyeuthichRepository.deleteById(id);
    }

    @Override
    public void delete(ProductYeuThich productyeuthich) {
        productyeuthichRepository.delete(productyeuthich);
    }

    @Override
    public void deleteAll() {
        productyeuthichRepository.deleteAll();
    }

    @Override
    public int count() {
        return (int) productyeuthichRepository.count();
    }

}