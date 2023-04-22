package com.example.appbanbanhv2.service;

import com.example.appbanbanhv2.entity.Users;
import com.example.appbanbanhv2.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public Users save(Users users) {
        return usersRepository.save(users);
    }

    @Override
    public Optional<Users> find(String id) {
        return usersRepository.findById(id);
    }

    @Override
    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public List<Users> findAll(Sort sort){
        return usersRepository.findAll(sort);
    }

    @Override
    public Page<Users> findAll(Pageable pageable){
        return usersRepository.findAll(pageable);
    }

    @Override
    public void delete(String id) {
    usersRepository.deleteById(id);
    }

    @Override
    public void delete(Users users) {
        usersRepository.delete(users);
    }

    @Override
    public void deleteAll() {
        usersRepository.deleteAll();
    }

    @Override
    public long count() {
        return usersRepository.count();
    }

}