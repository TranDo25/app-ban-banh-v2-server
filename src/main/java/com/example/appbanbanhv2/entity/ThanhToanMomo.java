package com.example.appbanbanhv2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "thanh_toan_momo")
public class ThanhToanMomo {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "email")
    private String email;

    @Column(name = "users_id")
    private Integer usersId;

    @Column(name = "payments_id")
    private Integer paymentsId;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSdt() {
        return this.sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getUsersId() {
        return this.usersId;
    }

    public void setUsersId(Integer usersId) {
        this.usersId = usersId;
    }

    public Integer getPaymentsId() {
        return this.paymentsId;
    }

    public void setPaymentsId(Integer paymentsId) {
        this.paymentsId = paymentsId;
    }
}
