package com.example.appbanbanhv2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class Category {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "ten_category")
    private String tenCategory;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenCategory() {
        return this.tenCategory;
    }

    public void setTenCategory(String tenCategory) {
        this.tenCategory = tenCategory;
    }
}
