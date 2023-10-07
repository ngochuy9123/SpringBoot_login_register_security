package com.spring_boot.login_register.service.impl;

import com.spring_boot.login_register.dto.UserDTO;
import com.spring_boot.login_register.entity.Role;
import com.spring_boot.login_register.entity.User;
import com.spring_boot.login_register.repository.UserRepository;
import com.spring_boot.login_register.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserDTO registrationDTO) {
        User user = new User(registrationDTO.getFirstName(),
                registrationDTO.getLastName(), registrationDTO.getEmail(),
                passwordEncoder.encode(registrationDTO.getPassword()) , "ROLE_USER");


        return userRepository.save(user);
    }



    @Override
    public Boolean checkEmail(String email) {

        return userRepository.existsByEmail(email);
    }
}
