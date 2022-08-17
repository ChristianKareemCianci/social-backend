package com.example.chiara.service;

import com.example.chiara.entity.UserDto;

import java.util.List;


public interface UserService {

    void save(UserDto userDto);

    List<UserDto> findAll();


    void update(UserDto userDTO);

    UserDto findUserById(int theId);

    List<UserDto> findUserByEmail(String email);

    List<UserDto> findUserByPassword(String password);
}
