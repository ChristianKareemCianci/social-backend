package com.example.messages.dao;

import com.example.messages.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/* Ciao */

import java.util.List;

@Repository
public interface MessageRepository extends CrudRepository<Message, Integer> {

    List<Message> findAll();
    List<Message> findByFromUserId(int fromUserId);
    List<Message> findByToUserId(int toUserId);

}

