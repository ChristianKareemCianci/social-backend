package com.example.messages.rest;

import com.example.messages.entity.MessageDto;
import com.example.messages.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    private static final Logger logger = LoggerFactory.getLogger(MessageController.class);

    @PostMapping("/save")
    public void saveNewMsg(@RequestBody MessageDto messageDto) {

        messageService.save(messageDto);
    }

    @GetMapping("/{fromUser}/{toUser}")
    public List<MessageDto> findByText(@PathVariable int fromUser, @PathVariable int toUser) {

        logger.info(">>> getting chat between user " + fromUser + " and user " + toUser);
        return messageService.messageByUsers(fromUser, toUser);
    }
}
