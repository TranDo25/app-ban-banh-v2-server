package com.example.appbanbanhv2.dto;

public class ProductAddToCartDTO {
    private String idUser;
    private int idProduct;
    private int soLuong;

    public ProductAddToCartDTO(String idUser, int idProduct, int soLuong) {
        this.idUser = idUser;
        this.idProduct = idProduct;
        this.soLuong = soLuong;
    }

    public ProductAddToCartDTO() {
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
