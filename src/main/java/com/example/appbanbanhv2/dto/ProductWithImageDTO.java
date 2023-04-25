package com.example.appbanbanhv2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductWithImageDTO implements Serializable {
    private Integer id;
    private String tenSp;
    private String moTa;
    private Double gia;
    private String hinhAnh;
    private Integer soVote;
    private Integer categoryId;
    private String imageName;
    private Double giamGia;

}
