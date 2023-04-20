package com.example.appbanbanhv2.dto;

public class OrdersDTO {
    private Integer id;
    private String ngayTaoDon;
    private Integer tongTien;
    private String trangThaiDonHang;
    private String momoToken;
    private String sdt;
    private Integer soluong;
    private Double tongtien;
    private String diachigiaohang;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNgayTaoDon() {
        return this.ngayTaoDon;
    }

    public void setNgayTaoDon(String ngayTaoDon) {
        this.ngayTaoDon = ngayTaoDon;
    }

    public Integer getTongTien() {
        return this.tongTien;
    }

    public void setTongTien(Integer tongTien) {
        this.tongTien = tongTien;
    }

    public String getTrangThaiDonHang() {
        return this.trangThaiDonHang;
    }

    public void setTrangThaiDonHang(String trangThaiDonHang) {
        this.trangThaiDonHang = trangThaiDonHang;
    }

    public String getMomoToken() {
        return this.momoToken;
    }

    public void setMomoToken(String momoToken) {
        this.momoToken = momoToken;
    }

    public String getSdt() {
        return this.sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Integer getSoluong() {
        return this.soluong;
    }

    public void setSoluong(Integer soluong) {
        this.soluong = soluong;
    }

    public Double getTongtien() {
        return this.tongtien;
    }

    public void setTongtien(Double tongtien) {
        this.tongtien = tongtien;
    }

    public String getDiachigiaohang() {
        return this.diachigiaohang;
    }

    public void setDiachigiaohang(String diachigiaohang) {
        this.diachigiaohang = diachigiaohang;
    }
}
