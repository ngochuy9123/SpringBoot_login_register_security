package com.spring_boot.login_register.service;

import com.spring_boot.login_register.dto.UserDTO;
import com.spring_boot.login_register.entity.User;

public interface UserService {
    User save(UserDTO userDTO);
    Boolean checkEmail(String email);

}
