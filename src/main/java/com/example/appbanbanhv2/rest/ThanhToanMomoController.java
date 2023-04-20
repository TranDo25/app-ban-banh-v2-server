package com.example.appbanbanhv2.rest;

import com.example.appbanbanhv2.entity.ThanhToanMomo;
import com.example.appbanbanhv2.service.ThanhToanMomoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("")
public class ThanhToanMomoController {

    @Autowired
    private ThanhToanMomoService thanhtoanmomoService;

    @PostMapping("/thanhtoanmomo")
    public ThanhToanMomo save(@RequestBody ThanhToanMomo thanhtoanmomo){
        return thanhtoanmomoService.save(thanhtoanmomo);
    }

    @GetMapping("/thanhtoanmomo/{id}")
    public Optional<ThanhToanMomo> getById(@PathVariable(value = "id") Long id){
        return thanhtoanmomoService.find(id);
    }

    @GetMapping("/thanhtoanmomo")
    public List<ThanhToanMomo> getAll(){
        return thanhtoanmomoService.findAll();
    }

    @DeleteMapping("/thanhtoanmomo/{id}")
    public void deleteById(@PathVariable(value = "id") Long id){
        thanhtoanmomoService.delete(id);
    }

    @DeleteMapping("/thanhtoanmomo")
    public void deleteAll(){
        thanhtoanmomoService.deleteAll();
    }

    @GetMapping("/thanhtoanmomo/count")
    public long count(){
        return thanhtoanmomoService.count();
    }
}