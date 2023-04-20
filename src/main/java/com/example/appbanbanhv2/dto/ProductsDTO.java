package com.example.appbanbanhv2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductsDTO implements Serializable {
    private Integer id;
    private String tenSp;
    private String moTa;
    private Double gia;
    private String hinhAnh;
    private Integer soVote;
    private Integer categoryId;
    private MultipartFile image;
    private Double giamGia;

   }
