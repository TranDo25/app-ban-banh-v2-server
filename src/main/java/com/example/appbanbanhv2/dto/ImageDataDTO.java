package com.example.appbanbanhv2.dto;

public class ImageDataDTO {
    private Integer id;
    private String imagedata;
    private String name;
    private String type;
    private Integer productsId;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImagedata() {
        return imagedata;
    }

    public void setImagedata(String imagedata) {
        this.imagedata = imagedata;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getProductsId() {
        return this.productsId;
    }

    public void setProductsId(Integer productsId) {
        this.productsId = productsId;
    }
}
