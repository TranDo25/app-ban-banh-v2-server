package com.example.appbanbanhv2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
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


    public ProductYeuThich() {

    }
}
