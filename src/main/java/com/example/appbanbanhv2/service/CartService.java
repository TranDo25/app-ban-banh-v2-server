package com.example.appbanbanhv2.service;

import com.example.appbanbanhv2.dto.ProductWithImageWithNumberDTO;
import com.example.appbanbanhv2.entity.Cart;
import com.example.appbanbanhv2.modelfrontend.GioHangModel;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface CartService {

	Cart save(Cart cart);

	Optional<Cart> find(Long id);

	List<Cart> findAll();

	List<Cart> findAll(Sort sort);

	Page<Cart> findAll(Pageable pageable);

	void delete(Long id);

	void delete(Cart cart);

	void deleteAll();

	long count();

	List<ProductWithImageWithNumberDTO> getGioHangByIdUser(String idUser);

	Cart findById(int cartId);

	String changeNumberOfItem(int cartId, int soluong);

	String addProductToCart(String iduser, int idProduct, int soluong);

    List<Cart> getListCartByIdUserNew(String idUser);
}