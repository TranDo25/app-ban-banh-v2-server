package com.example.appbanbanhv2.modelfrontend;

import java.util.ArrayList;
import java.util.List;

import com.example.appbanbanhv2.entity.Cart;
import com.example.appbanbanhv2.entity.Products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GioHangModel {
	private List<Products> dsMatHangTrongGio = new ArrayList<>();


}
