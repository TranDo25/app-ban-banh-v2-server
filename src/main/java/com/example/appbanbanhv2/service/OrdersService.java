package com.example.appbanbanhv2.service;

import com.example.appbanbanhv2.dto.ChiTietOrderDTO;
import com.example.appbanbanhv2.dto.MessageDTO;
import com.example.appbanbanhv2.entity.Cart;
import com.example.appbanbanhv2.entity.Orders;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface OrdersService {

    Orders save(Orders orders);

    Optional<Orders> find(Long id);

    List<Orders> findAll();

    List<Orders> findAll(Sort sort);

    Page<Orders> findAll(Pageable pageable);

    void delete(Long id);

    void delete(Orders orders);

    void deleteAll();

    long count();

    String createOrder(List<Cart> dsCart);

    String setThongTinGiaoHang(int idOrder, String sdt, String diaChiGiaoHang);

    String setToken(int idOrder, String token);

    String setTrangThaiDonHang(int idOrder, Integer codeStatus);

    ChiTietOrderDTO getChiTietOrder(int idOrder);

    MessageDTO getTheNewestOrderId();

    List<Orders> getOrderByIdUser(String idUser);
}