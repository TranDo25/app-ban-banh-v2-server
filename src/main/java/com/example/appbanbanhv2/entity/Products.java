package com.example.appbanbanhv2.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Products {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten_sp")
    private String tenSp;

    @Column(name = "mo_ta")
    private String moTa;

    @Column(name = "gia")
    private Double gia;



    @Column(name = "so_vote")
    private Integer soVote;
    @Column(name = "category_id")
    private Integer categoryId;
    @Column(name = "giam_gia")
    private Double giamGia;

    }
