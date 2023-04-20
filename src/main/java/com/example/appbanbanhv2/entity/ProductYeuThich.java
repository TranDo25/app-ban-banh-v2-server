package com.example.appbanbanhv2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product_yeu_thich")
public class ProductYeuThich {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_product")
    private Integer idProduct;

    @Column(name = "users_id")
    private String usersId;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdProduct() {
        return this.idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getUsersId() {
        return this.usersId;
    }

    public void setUsersId(String usersId) {
        this.usersId = usersId;
    }
}
