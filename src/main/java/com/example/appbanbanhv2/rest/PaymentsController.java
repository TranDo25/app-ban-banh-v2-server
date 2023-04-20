package com.example.appbanbanhv2.rest;


import com.example.appbanbanhv2.entity.Payments;
import com.example.appbanbanhv2.service.PaymentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("")
public class PaymentsController {

    @Autowired
    private PaymentsService paymentsService;

    @PostMapping("/payments")
    public Payments save(@RequestBody Payments payments){
        return paymentsService.save(payments);
    }

    @GetMapping("/payments/{id}")
    public Optional<Payments> getById(@PathVariable(value = "id") Long id){
        return paymentsService.find(id);
    }

    @GetMapping("/payments")
    public List<Payments> getAll(){
        return paymentsService.findAll();
    }

    @DeleteMapping("/payments/{id}")
    public void deleteById(@PathVariable(value = "id") Long id){
        paymentsService.delete(id);
    }

    @DeleteMapping("/payments")
    public void deleteAll(){
        paymentsService.deleteAll();
    }

    @GetMapping("/payments/count")
    public long count(){
        return paymentsService.count();
    }
}