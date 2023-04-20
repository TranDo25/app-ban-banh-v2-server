package com.example.appbanbanhv2.dto;

public class ThanhToanMomoDTO {
    private Integer id;
    private String sdt;
    private String email;
    private Integer usersId;
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
