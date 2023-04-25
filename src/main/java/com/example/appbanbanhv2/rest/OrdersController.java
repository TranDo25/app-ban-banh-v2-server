package com.example.appbanbanhv2.rest;

import com.example.appbanbanhv2.dto.MessageDTO;
import com.example.appbanbanhv2.entity.Orders;
import com.example.appbanbanhv2.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @PostMapping("/orders")
    public Orders save(@RequestBody Orders orders) {
        return ordersService.save(orders);
    }

    @GetMapping("/orders/{id}")
    public Optional<Orders> getById(@PathVariable(value = "id") Long id) {
        return ordersService.find(id);
    }

    @GetMapping("/orders")
    public List<Orders> getAll() {
        return ordersService.findAll();
    }

    @DeleteMapping("/orders/{id}")
    public void deleteById(@PathVariable(value = "id") Long id) {
        ordersService.delete(id);
    }

    @DeleteMapping("/orders")
    public void deleteAll() {
        ordersService.deleteAll();
    }

    @GetMapping("/orders/count")
    public long count() {
        return ordersService.count();
    }

    //lấy ra order id mới nhất
    @GetMapping("/order/getTheNewestOrderId")
    public ResponseEntity<MessageDTO> getTheNewestOrderId() {

        MessageDTO dto = ordersService.getTheNewestOrderId();
        return ResponseEntity.ok(dto);
    }
}
