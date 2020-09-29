package com.example.friendbook.controller;

import com.example.friendbook.dto.RegisterRequest;
import com.example.friendbook.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService auth_service;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody RegisterRequest register_request){
        auth_service.signup(register_request);
        return new ResponseEntity<String>("User Registration Successful", HttpStatus.OK);
    }
}
