package com.springboot.springsec.controller;

import com.springboot.springsec.model.Users;
import com.springboot.springsec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("register")
    public String register(@RequestBody Users user){
        return userService.register(user);
    }

    @GetMapping("getAll")
    public List<Users> getAll(@RequestBody Users user){
        return userService.getAll(user);
    }

    @PostMapping("login")
    public String login(@RequestBody Users user){
        return userService.verify(user);
    }


}
