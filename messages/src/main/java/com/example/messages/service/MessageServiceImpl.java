package com.example.messages.service;

import com.example.messages.dao.MessageRepository;
import com.example.messages.entity.Message;
import com.example.messages.entity.MessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageServiceImpl implements MessageService {


    private MessageRepository messageRepository;

    @Autowired
    public  MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void save(MessageDto messageDto) {

        Message newMessage = new Message(messageDto.getText(), messageDto.getFromUserId(), messageDto.getToUserId());

        messageRepository.save(newMessage);
    }

    @Override
    public List<MessageDto> messageByUsers(int fromUserId, int toUserId) {

        List<MessageDto> messageStream = messageRepository.findAll().parallelStream()
                .filter((element) -> element.getFromUserId() == fromUserId)
                .collect(Collectors.toList())
                .stream().map(x -> new MessageDto(x.getText(), x.getFromUserId(), x.getToUserId(), x.getId()))
                .collect(Collectors.toList());
        return messageStream;
    }
}
