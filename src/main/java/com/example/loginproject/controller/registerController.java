package com.example.loginproject.controller;

import com.example.loginproject.model.User;
import com.example.loginproject.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class registerController {

    private UserRepository usersDao;
    private PasswordEncoder passwordEncoder;

    public registerController(UserRepository usersDao, PasswordEncoder passwordEncoder) {
        this.usersDao = usersDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String registerNow(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/user/create")
    public String insertUser(@ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        usersDao.save(user);
        return "redirect:/";
    }

}