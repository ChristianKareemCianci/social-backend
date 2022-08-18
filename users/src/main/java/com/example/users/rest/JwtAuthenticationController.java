package com.example.users.rest;

import java.util.Objects;

import com.example.users.entity.UserDto;
import com.example.users.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import com.example.users.service.JwtUserDetailsService;


import com.example.users.config.JwtTokenUtil;
import com.example.users.entity.JwtRequest;
import com.example.users.entity.JwtResponse;

@RestController
//@RequestMapping("/api/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    UserService userService;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        try {
            authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());

            final UserDetails userDetails = userDetailsService
                    .loadUserByUsername(authenticationRequest.getEmail());


            final String token = jwtTokenUtil.generateToken(userDetails);

            logger.warn(">>>>> Generated token: " + new JwtResponse(token));
            return ResponseEntity.ok(new JwtResponse(token));

        } catch (Exception e) {
            throw new Exception();
        }
    }

    @PostMapping("/registration")
    public ResponseEntity<?> saveUser(@RequestBody UserDto user) throws Exception {

        UserDto sameUserEmail;

            if(userService.findUserByEmail(user.getEmail()).size() > 0) {
                sameUserEmail = userService.findUserByEmail(user.getEmail()).get(0);
            } else {
                sameUserEmail = null;
            }

            if(sameUserEmail == null) {
                return ResponseEntity.ok(userDetailsService.save(user));
            } else {
                logger.warn(">>> User already exists!!");
                throw new Exception("User already exists!");
            }

    }

    private void authenticate(String email, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}