package com.example.users.dao;


import com.example.users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public List<User> findAll();

    List<User> findUserByEmail(String email);
    User findUserById(int theId);

}