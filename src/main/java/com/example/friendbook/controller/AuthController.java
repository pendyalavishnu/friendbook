package com.example.friendbook.controller;


import com.example.friendbook.dto.LoginRequest;
import com.example.friendbook.model.User;
import com.example.friendbook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AuthController {

    @Autowired
    UserRepository user_repo;

    @PostMapping(path = "/register", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public boolean register(@RequestBody User user){
        List<Integer> num_row_count= user_repo.findByTxt_username(user.getTxt_username());
        if(num_row_count.size() > 0 ){
            return false;
        }
        user_repo.save(user);
        return true;
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public boolean login(@RequestBody LoginRequest login_request){
        String txt_pass = user_repo.findPasswordByUsername(login_request.getTxt_username());
        if(txt_pass == ""){
            return false;
        }
        System.out.print(txt_pass);
        return(txt_pass.equals(login_request.getTxt_password()));
    }
}
