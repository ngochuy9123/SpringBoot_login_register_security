package com.spring_boot.login_register.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class UserLoginController {



    @GetMapping
    public String showLoginForm(){
        return "login";
    }
}
