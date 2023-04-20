package com.example.appbanbanhv2.service;

import com.example.appbanbanhv2.entity.Category;
import com.example.appbanbanhv2.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Optional<Category> find(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> findAll(Sort sort){
        return categoryRepository.findAll(sort);
    }

    @Override
    public Page<Category> findAll(Pageable pageable){
        return categoryRepository.findAll(pageable);
    }

    @Override
    public void delete(Long id) {
    categoryRepository.deleteById(id);
    }

    @Override
    public void delete(Category category) {
        categoryRepository.delete(category);
    }

    @Override
    public void deleteAll() {
        categoryRepository.deleteAll();
    }

    @Override
    public long count() {
        return categoryRepository.count();
    }

}