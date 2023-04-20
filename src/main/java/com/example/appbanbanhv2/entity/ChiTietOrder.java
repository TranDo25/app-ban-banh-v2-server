package com.example.appbanbanhv2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "chi_tiet_order")
public class ChiTietOrder {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "orders_id")
    private Integer ordersId;

    @Column(name = "cart_id")
    private Integer cartId;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrdersId() {
        return this.ordersId;
    }

    public void setOrdersId(Integer ordersId) {
        this.ordersId = ordersId;
    }

    public Integer getCartId() {
        return this.cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }
}
