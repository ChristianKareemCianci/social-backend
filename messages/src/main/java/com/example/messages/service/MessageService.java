package com.example.messages.service;

import com.example.messages.entity.MessageDto;

import java.util.List;

public interface MessageService {

    void save(MessageDto newMsg);
    List<MessageDto> messageByUsers(int fromUserId, int toUserId);
}
