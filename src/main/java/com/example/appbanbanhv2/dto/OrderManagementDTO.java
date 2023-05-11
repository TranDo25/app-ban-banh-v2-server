package com.example.appbanbanhv2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderManagementDTO {
    private OrderWrapperDTO orderWrapperDTO;
    private List<String> listTrangThaiGiaoHang;
}
