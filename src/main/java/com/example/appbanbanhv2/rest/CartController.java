package com.example.appbanbanhv2.rest;


import com.example.appbanbanhv2.entity.Cart;
import com.example.appbanbanhv2.modelfrontend.GioHangModel;
import com.example.appbanbanhv2.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("")

public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/cart")
    public Cart save(@RequestBody Cart cart){
        return cartService.save(cart);
    }

    @GetMapping("/cart/{id}")
    public Optional<Cart> getById(@PathVariable(value = "id") Long id){
        return cartService.find(id);
    }

    @GetMapping("/cart/getCartByIdUser")
    public GioHangModel getCartByIdUser(@RequestParam("iduser") String iduser){
        return cartService.getGioHangByIdUser(iduser);
    }
    @GetMapping("/cart")
    public List<Cart> getAll(){
        return cartService.findAll();
    }

    @DeleteMapping("/cart/{id}")
    public void deleteById(@PathVariable(value = "id") Long id){
        cartService.delete(id);
    }

    @DeleteMapping("/cart")
    public void deleteAll(){
        cartService.deleteAll();
    }

    @GetMapping("/cart/count")
    public long count(){
        return cartService.count();
    }
}