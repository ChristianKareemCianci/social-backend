package com.example.users.service;

import java.util.ArrayList;
import java.util.List;

import com.example.users.config.WebSecurityConfig;
import com.example.users.entity.UserDto;
import com.example.users.entity.User;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private WebSecurityConfig webSecurityConfig;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        List<UserDto> userList = userService.findUserByEmail(email);

        UserDto user = userList.get(0);

        if(user == null) {
            throw new UsernameNotFoundException(("user not found with email: " + email));
        }

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                new ArrayList<>());
    }

    public UserDto save(UserDto user) {
        UserDto newUser = new UserDto(user.getEmail(),
                new BCryptPasswordEncoder().encode(user.getPassword()));

        userService.save(newUser);
        return newUser;
    }
}