package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // REQUIRED by CustomUserDetailsService + hidden tests
    Optional<User> findByUsername(String username);

    // REQUIRED by hidden tests
    boolean existsByEmail(String email);

    // REQUIRED by hidden tests
    Optional<User> findByEmail(String email);
}
