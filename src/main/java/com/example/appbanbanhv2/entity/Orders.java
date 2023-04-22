package com.example.appbanbanhv2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "ngay_tao_don")
    private String ngayTaoDon;


    @Column(name = "trang_thai_don_hang")
    private String trangThaiDonHang;

    @Column(name = "momo_token")
    private String momoToken;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "soluong")
    private Integer soluong;

    @Column(name = "tongtien")
    private Double tongtien;

    @Column(name = "diachigiaohang")
    private String diachigiaohang;

    public Orders(int id,String ngayTaoDon, String trangThaiDonHang, String momoToken, String sdt, Integer soluong, Double tongtien, String diachigiaohang) {
        this.id = id;
        this.ngayTaoDon = ngayTaoDon;
        this.trangThaiDonHang = trangThaiDonHang;
        this.momoToken = momoToken;
        this.sdt = sdt;
        this.soluong = soluong;
        this.tongtien = tongtien;
        this.diachigiaohang = diachigiaohang;
    }

    public Orders() {

    }

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
