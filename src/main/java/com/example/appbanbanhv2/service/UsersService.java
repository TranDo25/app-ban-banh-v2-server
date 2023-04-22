package com.example.appbanbanhv2.service;


import com.example.appbanbanhv2.entity.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface UsersService {

    Users save(Users users);

    Optional<Users> find(String id);

    List<Users> findAll();

    List<Users> findAll(Sort sort);

    Page<Users> findAll(Pageable pageable);

    void delete(String id);

    void delete(Users users);

    void deleteAll();

    long count();

}