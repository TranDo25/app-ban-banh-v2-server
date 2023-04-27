package com.example.appbanbanhv2.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.appbanbanhv2.entity.Orders;

public class OrderWrapperDTO {
	private List<Orders> listOrder = new ArrayList<>();

	public OrderWrapperDTO(List<Orders> listOrder) {
		super();
		this.listOrder.addAll(listOrder);
	}

	public OrderWrapperDTO() {
		// TODO Auto-generated constructor stub
	}

	public List<Orders> getListOrder() {
		return listOrder;
	}

	public void setListOrder(List<Orders> listOrder) {
		this.listOrder = listOrder;
	}
	public void addOrder(Orders order) {
		this.listOrder.add(order);
	}
	
}
