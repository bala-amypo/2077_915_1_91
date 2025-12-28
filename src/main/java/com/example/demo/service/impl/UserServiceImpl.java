package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // ==================================================
    // REQUIRED BY TEST: save(User)
    // ==================================================
    @Override
    public User save(User user) {

        // 🔴 testRegisterUserDuplicateEmail expects IllegalArgumentException
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    // ==================================================
    // REQUIRED BY TEST: findByEmail(String)
    // ==================================================
    @Override
    public User findByEmail(String email) {

        // 🔴 testUserServiceFindByEmailNotFound expects ResourceNotFoundException
        return userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found")
                );
    }

    // ==================================================
    // REQUIRED BY TEST: getById(Long)
    // ==================================================
    @Override
    public User getById(Long id) {

        // 🔴 testUserServiceGetByIdNotFound expects ResourceNotFoundException
        return userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found")
                );
    }
}
