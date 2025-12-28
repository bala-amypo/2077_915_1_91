package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {

    // Used by tests: testUserServiceGetByIdSuccess / NotFound
    User getById(Long id);

    // Used by registration flow & duplicate email test
    User save(User user);

    // 🔴 REQUIRED BY TESTS
    // testUserServiceFindByEmailNotFound
    User findByEmail(String email);
}
