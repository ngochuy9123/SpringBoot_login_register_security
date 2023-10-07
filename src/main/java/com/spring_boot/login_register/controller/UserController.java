package com.spring_boot.login_register.controller;

import com.spring_boot.login_register.dto.UserDTO;
import com.spring_boot.login_register.entity.User;
import com.spring_boot.login_register.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signin")
    public String showSignInForm(){
        return "login";
    }

    @GetMapping("/register")
    public String showRegistrationForm(){
        return "register";
    }

    @PostMapping("/register")
    public String registerUserAccount(@ModelAttribute("user") UserDTO registrationDTO, HttpSession session){
        boolean f = userService.checkEmail(registrationDTO.getEmail());
        if (f){
            session.setAttribute("msgReg","EMAIL DA TON TAI");
        }
        else{
            User u = userService.save(registrationDTO);
            if (u==null){
                session.setAttribute("msgReg","DANG KI THAT BAI");
            }
            else{
                session.setAttribute("msgReg","DANG KI THANH CONG");
            }
        }
        return "redirect:/register";

    }
}
