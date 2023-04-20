package com.example.appbanbanhv2.rest;

import com.example.appbanbanhv2.entity.ProductYeuThich;
import com.example.appbanbanhv2.service.ProductYeuThichService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("")
public class ProductYeuThichController {

    @Autowired
    private ProductYeuThichService productyeuthichService;

    @PostMapping("/productyeuthich")
    public ProductYeuThich save(@RequestBody ProductYeuThich productyeuthich){
        return productyeuthichService.save(productyeuthich);
    }

    @GetMapping("/productyeuthich/{id}")
    public Optional<ProductYeuThich> getById(@PathVariable(value = "id") Long id){
        return productyeuthichService.find(id);
    }

    @GetMapping("/productyeuthich")
    public List<ProductYeuThich> getAll(){
        return productyeuthichService.findAll();
    }

    @DeleteMapping("/productyeuthich/{id}")
    public void deleteById(@PathVariable(value = "id") Long id){
        productyeuthichService.delete(id);
    }

    @DeleteMapping("/productyeuthich")
    public void deleteAll(){
        productyeuthichService.deleteAll();
    }

    @GetMapping("/productyeuthich/count")
    public long count(){
        return productyeuthichService.count();
    }
}