package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // ✅ REQUIRED CONSTRUCTOR
    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // ✅ REQUIRED
    public User register(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            return null;
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    // ✅ REQUIRED
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    // ✅ REQUIRED
    public User getById(long id) {
        return userRepository.findById(id).orElse(null);
    }
}
