package com.example.appbanbanhv2.rest;

import com.example.appbanbanhv2.entity.Products;
import com.example.appbanbanhv2.service.ProductsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("")
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @GetMapping("/10products")
    public List<Products> find10product()
    {
        return productsService.find10product();
    }
    @PostMapping("/products")
    public Products save(@RequestBody Products products){
        return productsService.save(products);
    }

    @GetMapping("/products/{id}")
    public Optional<Products> getById(@PathVariable(value = "id") Integer id){
        return productsService.find(id);
    }

    @GetMapping("/products")
    public List<Products> getAll(){
        return productsService.findAll();
    }

    @DeleteMapping("/products/{id}")
    public void deleteById(@PathVariable(value = "id") Integer id){
        productsService.delete(id);
    }

    @DeleteMapping("/products")
    public void deleteAll(){
        productsService.deleteAll();
    }

    @GetMapping("/products/count")
    public long count(){
        return productsService.count();
    }
}