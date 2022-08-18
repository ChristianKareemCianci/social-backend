package com.example.users.rest;

import com.example.users.entity.UserDto;
import com.example.users.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController
@RequestMapping("/api/user")
public class UserController {


    @Autowired
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    @GetMapping("/all")
    public List<UserDto> findAllUsers() {
        logger.info(">>> Request user lists");
        return userService.findAll();
    }

    @GetMapping("/{email}")
    public List<UserDto> findUserByEmail(@PathVariable String email) {

        logger.info(">>> Finding user by email " + email);

        return userService.findUserByEmail(email);
    }


    @PostMapping("/login")
    public UserDto checkUserCredentials(@RequestBody UserDto userDto) {

        logger.info(">>> Login Request Started...");
        String email = userDto.getEmail();
        List<UserDto> matches = findUserByEmail(email);

        if(matches.size() > 0) {

            if(matches.get(0).getPassword().equals(userDto.getPassword())) {

                logger.info(">>> User found. Authenticated!" + matches.get(0).getId());

                return matches.get(0);
            }
            else {

                logger.info(">>> NO USER WITH THIS PASSWORD");
                return null;
            }
        } else {

            logger.info(">>> NO USER WITH THIS EMAIL");
            return null;
        }

    }

    @PostMapping("/save")
    public void saveUser(@RequestBody UserDto userDto) {

        userService.save(userDto);
    }
}
