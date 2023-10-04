package com.spring_boot.login_register.controller;

import com.spring_boot.login_register.dto.UserRegistrationDTO;
import com.spring_boot.login_register.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class UserRegistrationController {
    private UserService userService;

    public UserRegistrationController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public String showRegistrationForm(){
        return "register";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDTO registrationDTO){
        userService.save(registrationDTO);
        return "redirect:/register?success";
    }

}
