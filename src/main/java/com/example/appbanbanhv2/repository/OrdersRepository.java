package com.example.appbanbanhv2.repository;

import com.example.appbanbanhv2.dto.ChiTietOrderDTO;
import com.example.appbanbanhv2.entity.Orders;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
    @Query(value = "SELECT id FROM orders ORDER BY id DESC LIMIT 1;",nativeQuery = true)
    Integer getTheLastestId();

    @Query(value = "select orders.id,\n" +
            "orders.ngay_tao_don,\n" +
            "orders.trang_thai_don_hang,\n" +
            "orders.zalopay_token,\n" +
            "orders.sdt,\n" +
            "orders.soluong,\n" +
            "orders.tongtien,\n" +
            "orders.diachigiaohang,\n" +
            "orders.momo_token\n" +
            "  from orders, chi_tiet_order, cart, users \n" +
            "where chi_tiet_order.orders_id = orders.id\n" +
            "and chi_tiet_order.cart_id = cart.id\n" +
            "and cart.users_id = users.id\n" +
            "and users.id = ?1\n" +
            "group by orders.id",nativeQuery = true)

    List<Orders> getOrderByIdUser(String idUser);
}