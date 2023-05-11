package com.example.appbanbanhv2.controller;

import com.example.appbanbanhv2.dto.MessageDTO;
import com.example.appbanbanhv2.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserManager {
    @Autowired
    private UsersService usersService;
    @GetMapping("/api/v2/addAccountToDB")
    public ResponseEntity<MessageDTO> addAccountToDB(@RequestParam("email") String email, @RequestParam("hoTen") String hoTen){
        MessageDTO dto = new MessageDTO(usersService.addNewUserAccountToDB(email, hoTen));
        return ResponseEntity.ok(dto);
    }

}
