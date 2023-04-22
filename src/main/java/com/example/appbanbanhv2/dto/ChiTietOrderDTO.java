package com.example.appbanbanhv2.dto;

import com.example.appbanbanhv2.entity.ChiTietOrder;
import com.example.appbanbanhv2.entity.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChiTietOrderDTO {
    private Orders orders;

    private List<ChiTietOrder> chiTietOrderList;

}
