package com.example.users.service;

import com.example.users.entity.UserDto;

import java.util.List;


public interface UserService {

    UserDto save(UserDto userDto);

    List<UserDto> findAll();


    void update(UserDto userDTO);

    UserDto findUserById(int theId);

    List<UserDto> findUserByEmail(String email);

}
