package com.example.appbanbanhv2.repository;



import com.example.appbanbanhv2.entity.Cart;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CartRepository extends JpaRepository<Cart, Long> {
	@Query(value="select * from cart where users_id = ?1", nativeQuery = true)
	List<Cart> findAllByUserId(String idUser);
	@Query(value = "SELECT id FROM cart ORDER BY id DESC LIMIT 1", nativeQuery = true)
	long getNewestProductId();
	@Query(value = "SELECT * FROM cart WHERE cart.users_id = ?1", nativeQuery = true)
    List<Cart> getListCartByIdUserNew(String idUser);
}