package com.example.appbanbanhv2.rest;

import com.example.appbanbanhv2.entity.Cart;
import com.example.appbanbanhv2.entity.Users;
import com.example.appbanbanhv2.modelfrontend.GioHangModel;
import com.example.appbanbanhv2.repository.UsersRepository;
import com.example.appbanbanhv2.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("")

public class CartController {

	@Autowired
	private CartService cartService;
//	@Autowired
//	private UsersRepository usersRepository;

	@PostMapping("/cart")
	public Cart save(@RequestBody Cart cart) {
		return cartService.save(cart);
	}

	// Tuấn anh viết
	// api thêm mới sản phẩm vào giỏ hàng


	@GetMapping("/cart/{id}")
	public Optional<Cart> getById(@PathVariable(value = "id") Long id) {
		return cartService.find(id);
	}
//thay đổi số lượng của cart item trong giỏ hàng
	@GetMapping("/cart/changeNumberOfItem")
	public String changeNumberOfItem(@RequestParam("cartId") int cartId, @RequestParam("soluong") int soluong) {
		String res = cartService.changeNumberOfItem(cartId, soluong);
		return res;
	}
//api get giở hàng theo id user
	@GetMapping("/cart/getCartByIdUser")
	public GioHangModel getCartByIdUser(@RequestParam("iduser") String iduser) {
		return cartService.getGioHangByIdUser(iduser);
	}

	@GetMapping("/cart")
	public List<Cart> getAll() {
		return cartService.findAll();
	}

	@DeleteMapping("/cart/{id}")
	public void deleteById(@PathVariable(value = "id") Long id) {
		cartService.delete(id);
	}

	@DeleteMapping("/cart")
	public void deleteAll() {
		cartService.deleteAll();
	}

	@GetMapping("/cart/count")
	public long count() {
		return cartService.count();
	}
}