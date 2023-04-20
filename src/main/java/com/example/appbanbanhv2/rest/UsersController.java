package com.example.appbanbanhv2.rest;


import com.example.appbanbanhv2.entity.Users;
import com.example.appbanbanhv2.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/users")
    public Users save(@RequestBody Users users){
        return usersService.save(users);
    }

    @GetMapping("/users/{id}")
    public Optional<Users> getById(@PathVariable(value = "id") Long id){
        return usersService.find(id);
    }

    @GetMapping("/users")
    public List<Users> getAll(){
        return usersService.findAll();
    }

    @DeleteMapping("/users/{id}")
    public void deleteById(@PathVariable(value = "id") Long id){
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