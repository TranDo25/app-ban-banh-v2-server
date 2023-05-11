package com.example.appbanbanhv2.controller;

import com.example.appbanbanhv2.dto.ChiTietOrderDTO;
import com.example.appbanbanhv2.dto.MessageDTO;
import com.example.appbanbanhv2.entity.Cart;
import com.example.appbanbanhv2.entity.Orders;
import com.example.appbanbanhv2.service.OrdersService;
import com.example.appbanbanhv2.smsWIthTwilio.Service;
import com.example.appbanbanhv2.smsWIthTwilio.SmsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
public class OrderManager {

    @Autowired
    private OrdersService orderService;
    @Autowired
    private Service smsService;


    //api create đơn hàng
    @PostMapping("/api/order/createOrder")
    public ResponseEntity<String> createOrder(@RequestBody List<Cart> dsCart) {
        String tmp = orderService.createOrder(dsCart);
        return ResponseEntity.ok(tmp);
    }

    //api set thong tin giao hàng
    @PutMapping("/api/order/setThongTinGiaoHang")
    public ResponseEntity<MessageDTO> setThongTinGiaoHang(@RequestParam("idDonHang") int idOrder, @RequestParam("sdt") String sdt, @RequestParam("diaChiGiaoHang") String diaChiGiaoHang) {
        String tmp = orderService.setThongTinGiaoHang(idOrder, sdt, diaChiGiaoHang);
        MessageDTO dto = new MessageDTO(tmp);
        return ResponseEntity.ok(dto);
    }

    //api set token zalopay
    @GetMapping("/api/order/setToken")
    public ResponseEntity<MessageDTO> setToken(@RequestParam("idDonHang") int idOrder, @RequestParam("token") String token) {
        WebClient webClient = WebClient.create("http://localhost:8080");
        SmsRequest smsRequest = new SmsRequest("+84825124160", "đơn hàng " + token + " đã được thanh toán thành công");
        smsService.sendSms(smsRequest);
        String tmp = orderService.setToken(idOrder + 1, token);
        MessageDTO dto = new MessageDTO(tmp);
        return ResponseEntity.ok(dto);
    }

    //set trạng thái đơn hàng
    @PutMapping("/api/order/changeOrderStatus")
    public ResponseEntity<String> setTrangThaiDonHang(@RequestParam("idDonHang") int idOrder, @RequestParam("codeStatus") Integer codeStatus) {
        String tmp = orderService.setTrangThaiDonHang(idOrder, codeStatus);
        return ResponseEntity.ok(tmp);
    }

    //get chi tiết order
    @GetMapping("/api/order/getChiTietOrder")
    public ResponseEntity<ChiTietOrderDTO> getChiTietOrder(@RequestParam("idDonHang") int idOrder) {
        ChiTietOrderDTO chiTietOrderDTO = orderService.getChiTietOrder(idOrder);
        return ResponseEntity.ok(chiTietOrderDTO);
    }

    //get all order by id user
    @GetMapping("/order/getAllOrderByIdUser")
    public ResponseEntity<List<Orders>> getAllOrderByIdUser(@RequestParam("idUser") String idUser) {
        List<Orders> res = orderService.getOrderByIdUser(idUser);
        return ResponseEntity.ok(res);
    }
}
