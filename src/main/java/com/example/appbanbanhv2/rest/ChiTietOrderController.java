package com.example.appbanbanhv2.rest;

import com.example.appbanbanhv2.entity.ChiTietOrder;
import com.example.appbanbanhv2.service.ChiTietOrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("")
public class ChiTietOrderController {

    @Autowired
    private ChiTietOrderService chitietorderService;

    @PostMapping("/chitietorder")
    public ChiTietOrder save(@RequestBody ChiTietOrder chitietorder){
        return chitietorderService.save(chitietorder);
    }

    @GetMapping("/chitietorder/{id}")
    public Optional<ChiTietOrder> getById(@PathVariable(value = "id") Long id){
        return chitietorderService.find(id);
    }

    @GetMapping("/chitietorder")
    public List<ChiTietOrder> getAll(){
        return chitietorderService.findAll();
    }

    @DeleteMapping("/chitietorder/{id}")
    public void deleteById(@PathVariable(value = "id") Long id){
        chitietorderService.delete(id);
    }

    @DeleteMapping("/chitietorder")
    public void deleteAll(){
        chitietorderService.deleteAll();
    }

    @GetMapping("/chitietorder/count")
    public long count(){
        return chitietorderService.count();
    }
}