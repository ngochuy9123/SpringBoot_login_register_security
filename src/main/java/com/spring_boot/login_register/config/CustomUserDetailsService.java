package com.spring_boot.login_register.config;

import com.spring_boot.login_register.entity.User;
import com.spring_boot.login_register.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository ;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);



        if(user==null){
            throw new UsernameNotFoundException("User Not Found");
        }
        else{
            return new CustomUser(user);
        }

    }
}