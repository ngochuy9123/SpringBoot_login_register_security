package com.spring_boot.login_register.service;

import com.spring_boot.login_register.dto.UserRegistrationDTO;
import com.spring_boot.login_register.entity.User;

public interface UserService {
    User save(UserRegistrationDTO registrationDTO);
}
