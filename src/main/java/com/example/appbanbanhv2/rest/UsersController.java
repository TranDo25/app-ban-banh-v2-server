package com.example.appbanbanhv2.rest;


import com.example.appbanbanhv2.entity.ProductYeuThich;
import com.example.appbanbanhv2.entity.Users;
import com.example.appbanbanhv2.service.ProductYeuThichService;
import com.example.appbanbanhv2.service.ProductsService;
import com.example.appbanbanhv2.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("")
public class UsersController {

    @Autowired
    private UsersService usersService;
    @Autowired
    private ProductYeuThichService productYeuThichService;

    @PostMapping("/users")
    public Users save(@RequestBody Users users){
        return usersService.save(users);
    }

    @GetMapping("/users/like")
    public ResponseEntity<String> likeProduct(@RequestParam("product_id") Integer product_id, @RequestParam("users_id") String user_id ){
   Optional <ProductYeuThich> productYeuThich = productYeuThichService.findByproduct_idAndUser_id(product_id,user_id);
   if(productYeuThich.isPresent()) return ResponseEntity.ok("San pham da duoc yeu thich");
   ProductYeuThich productYeuThich1 = new ProductYeuThich();

   productYeuThich1.setIdProduct(product_id);
   productYeuThich1.setUsersId(user_id);
   productYeuThich1.setId(productYeuThichService.count()+1);
   productYeuThichService.save(productYeuThich1);
   return ResponseEntity.ok("ok");

    }

    @GetMapping("/users/{id}")
    public Optional<Users> getById(@PathVariable(value = "id") String id){
        return usersService.find(id);
    }

    @GetMapping("/users")
    public List<Users> getAll(){
        return usersService.findAll();
    }

    @DeleteMapping("/users/{id}")
    public void deleteById(@PathVariable(value = "id") String id){
        usersService.delete(id);
    }

    @DeleteMapping("/users")
    public void deleteAll(){
        usersService.deleteAll();
    }

    @GetMapping("/users/count")
    public long count(){
        return usersService.count();
    }
}