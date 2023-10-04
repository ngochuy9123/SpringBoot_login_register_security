package com.spring_boot.login_register.service.impl;

import com.spring_boot.login_register.dto.UserRegistrationDTO;
import com.spring_boot.login_register.entity.Role;
import com.spring_boot.login_register.entity.User;
import com.spring_boot.login_register.repository.UserRepository;
import com.spring_boot.login_register.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(UserRegistrationDTO registrationDTO) {
        User user = new User(registrationDTO.getFirstName(),
                registrationDTO.getLastName(), registrationDTO.getEmail(),
                registrationDTO.getPassword(), Arrays.asList(new Role("ROLE_USER")));


        return userRepository.save(user);
    }
}
