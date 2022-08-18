package com.example.users.service;

import com.example.users.entity.User;
import com.example.users.entity.UserDto;
import com.example.users.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{


    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto save(UserDto userDto) {
        User user = new User(userDto.getEmail(), userDto.getPassword());

//      using jpa
        userRepository.save(user);
        return userDto;
    }


    @Override
    public List<UserDto> findAll() {

        return userRepository.findAll().stream()
                .map(x -> new UserDto(x.getEmail(),x.getPassword(),
                        x.getId())).collect(Collectors.toList());
    }

    @Override
    public void update(UserDto userDTO) {

    }

    @Override
    public UserDto findUserById(int theId) {

        return null;
    }

    @Override
    public List<UserDto> findUserByEmail(String email) {

        return userRepository.findUserByEmail(email).parallelStream()
                .filter((element)-> element.getEmail().equals(email))
                .collect(Collectors.toList())
                .stream().map(x -> new UserDto(x.getEmail(), x.getPassword(), x.getId()))
                .collect(Collectors.toList());
    }

}
