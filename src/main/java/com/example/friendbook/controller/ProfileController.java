package com.example.friendbook.controller;

import com.example.friendbook.model.Post;
import com.example.friendbook.repository.PostRepository;
import com.example.friendbook.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProfileController {
    @Autowired
    ProfileService profile_service;

    @GetMapping("/{username}")
    public ResponseEntity<List<Post>> getPostsByUser (@PathVariable("username") String txt_username){
        return new ResponseEntity<>(profile_service.getPostsByUser(txt_username), HttpStatus.OK);
    }

}
