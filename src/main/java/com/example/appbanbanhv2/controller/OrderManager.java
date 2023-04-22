package com.example.appbanbanhv2.controller;

import com.example.appbanbanhv2.entity.Cart;
import com.example.appbanbanhv2.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderManager {
    @Autowired
    private OrdersService orderService;
    //api create đơn hàng
    @PostMapping("/api/order/createOrder")
    public ResponseEntity<String> createOrder(@RequestBody List<Cart> dsCart) {
       String tmp = orderService.createOrder(dsCart);
          return ResponseEntity.ok(tmp);
    }
    @PutMapping("/api/order/setThongTinGiaoHang")
    public ResponseEntity<String> setThongTinGiaoHang(@RequestParam("idDonHang") int idOrder,@RequestParam("sdt") String sdt, @RequestParam("diaChiGiaoHang") String diaChiGiaoHang){
        String tmp = orderService.setThongTinGiaoHang(idOrder,sdt,diaChiGiaoHang);
        return ResponseEntity.ok(tmp);
    }
    @PutMapping("/api/order/setToken")
    public ResponseEntity<String> setToken(@RequestParam("idDonHang") int idOrder, @RequestParam("token") String token )
    {
        String tmp = orderService.setToken(idOrder,token);
        return ResponseEntity.ok(tmp);
    }
}
