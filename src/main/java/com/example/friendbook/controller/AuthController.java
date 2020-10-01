package com.example.friendbook.controller;

import com.example.friendbook.dto.RegisterRequest;
import com.example.friendbook.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;

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

    @GetMapping("/accountVerification/{txt_token}")
    public ResponseEntity<String> verifyAccount(@PathVariable String txt_token){
        auth_service.verfifyAccount(txt_token);
        return new ResponseEntity<>("Verification Successful", HttpStatus.OK);
    }
}
