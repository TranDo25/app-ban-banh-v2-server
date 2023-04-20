package com.example.appbanbanhv2.rest;


import com.example.appbanbanhv2.entity.Category;
import com.example.appbanbanhv2.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/category")
    public Category save(@RequestBody Category category){
        return categoryService.save(category);
    }

    @GetMapping("/category/{id}")
    public Optional<Category> getById(@PathVariable(value = "id") Long id){
        return categoryService.find(id);
    }

    @GetMapping("/category")
    public List<Category> getAll(){
        return categoryService.findAll();
    }

    @DeleteMapping("/category/{id}")
    public void deleteById(@PathVariable(value = "id") Long id){
        categoryService.delete(id);
    }

    @DeleteMapping("/category")
    public void deleteAll(){
        categoryService.deleteAll();
    }

    @GetMapping("/category/count")
    public long count(){
        return categoryService.count();
    }
}