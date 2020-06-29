package com.example.UserRegistration.service;

import com.example.UserRegistration.model.User;
import com.example.UserRegistration.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
    User findByEmail(String email);

}
