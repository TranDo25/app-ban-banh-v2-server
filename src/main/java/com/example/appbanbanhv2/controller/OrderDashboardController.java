package com.example.appbanbanhv2.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.appbanbanhv2.dto.OrderManagementDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.appbanbanhv2.dto.OrderWrapperDTO;
import com.example.appbanbanhv2.entity.Category;
import com.example.appbanbanhv2.entity.Orders;
import com.example.appbanbanhv2.service.CategoryService;
import com.example.appbanbanhv2.service.OrdersService;

@Controller
public class OrderDashboardController {
	@Autowired
	private OrdersService orderService;
	@Autowired
	private CategoryService _categoryService;

	// view quản lý đơn hàng
	// gói đối tượng vào trong một wrapper DTO để có thể đem qua thymeleaf
	// lý do vì không thể biểu diễn 1 list các đối tượng bên thymeleaf để update
	// trạng thái
	// của đối tượng
	@GetMapping("/admin/order/orderManagement")
	public String index(Model model) {
		List<Orders> listOrder = orderService.findAll();
		OrderWrapperDTO orderWrapperDTO = new OrderWrapperDTO(listOrder);
		//lấy về message redirect từ action khác
		String message = (String) model.asMap().get("message");
		model.addAttribute("message", message);
		List<String> listTrangThaiGiaoHang = new ArrayList<>();
		listTrangThaiGiaoHang.add("created");
		listTrangThaiGiaoHang.add("prepared");
		listTrangThaiGiaoHang.add("delivering");
		listTrangThaiGiaoHang.add("delivered");
		listTrangThaiGiaoHang.add("cancelled");
//	    	List<Category> listCategory = _categoryService.findAll(); 
		model.addAttribute("orderWrapperDTO", orderWrapperDTO);
//	    	model.addAttribute("listCategory", listCategory);
		model.addAttribute("listTrangThaiGiaoHang", listTrangThaiGiaoHang);
		return "order_management";
	}
	@GetMapping("/api/admin/order/orderManagement")
	public ResponseEntity<OrderManagementDTO> indexApi(Model model) {
		List<Orders> listOrder = orderService.findAll();
		OrderWrapperDTO orderWrapperDTO = new OrderWrapperDTO(listOrder);
		//lấy về message redirect từ action khác
		String message = (String) model.asMap().get("message");
		model.addAttribute("message", message);
		List<String> listTrangThaiGiaoHang = new ArrayList<>();
		listTrangThaiGiaoHang.add("created");
		listTrangThaiGiaoHang.add("prepared");
		listTrangThaiGiaoHang.add("delivering");
		listTrangThaiGiaoHang.add("delivered");
		listTrangThaiGiaoHang.add("cancelled");
//	    	List<Category> listCategory = _categoryService.findAll();
		OrderManagementDTO dto = new OrderManagementDTO(orderWrapperDTO, listTrangThaiGiaoHang);
//		model.addAttribute("orderWrapperDTO", orderWrapperDTO);
////	    	model.addAttribute("listCategory", listCategory);
//		model.addAttribute("listTrangThaiGiaoHang", listTrangThaiGiaoHang);
		return ResponseEntity.ok(dto);
	}
	@PostMapping(path = "/admin/order/saveListStatus", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
	public String processUpdateManyStatus(OrderWrapperDTO order, RedirectAttributes redirectAttributes) {
		List<Orders> orderFromDTO = order.getListOrder();
		String message = "";
		boolean flag = false;
		for (Orders i : orderFromDTO) {
			try {
			
				orderService.save(i);

			} catch (Exception e) {
				e.printStackTrace();
				message = "error in update orders status";
				flag = true;
			}
		}
		if (flag == false) {
			message = "update orders status successful";
		}
		redirectAttributes.addFlashAttribute("message", message);

		return "redirect:/admin/order/orderManagement";

	}
}
