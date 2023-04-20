package com.example.appbanbanhv2.dto;

public class PaymentsDTO {
    private Integer id;
    private String phuongThucThanhToan;
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
