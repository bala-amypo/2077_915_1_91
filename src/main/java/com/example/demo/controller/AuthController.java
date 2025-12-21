package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

  private final UserService userService;
  private final PasswordEncoder passwordEncoder;

  public AuthController(UserService userService, PasswordEncoder passwordEncoder) {
    this.userService = userService;
    this.passwordEncoder = passwordEncoder;
  }

  @PostMapping("/register")
  public ResponseEntity<User> register(@RequestBody User user) {
    User savedUser = userService.register(user);
    return ResponseEntity.ok(savedUser);
  }

  @PostMapping("/login")
  public ResponseEntity<User> login(@RequestBody User user) {
    User existingUser = userService.findByEmail(user.getEmail());

    if (!passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
      throw new IllegalArgumentException("Invalid credentials");
    }

    return ResponseEntity.ok(existingUser);
  }
}
