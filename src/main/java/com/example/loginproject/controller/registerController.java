package com.example.loginproject.controller;

import com.example.loginproject.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class registerController {

    private UserRepository usersDao;

    public registerController(UserRepository usersDao){
        this.usersDao = usersDao;
    }

    @GetMapping("/register")
    public String registerNow(){
        return "register";
    }

}