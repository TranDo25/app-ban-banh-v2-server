package com.example.appbanbanhv2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "payments")
public class Payments {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "phuong_thuc_thanh_toan")
    private String phuongThucThanhToan;

    @Column(name = "users_id")
    private String usersId;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhuongThucThanhToan() {
        return this.phuongThucThanhToan;
    }

    public void setPhuongThucThanhToan(String phuongThucThanhToan) {
        this.phuongThucThanhToan = phuongThucThanhToan;
    }

    public String getUsersId() {
        return this.usersId;
    }

    public void setUsersId(String usersId) {
        this.usersId = usersId;
    }
}
