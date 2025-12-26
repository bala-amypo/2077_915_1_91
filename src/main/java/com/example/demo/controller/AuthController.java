package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/auth")
@Tag(name = "Auth Controller")
public class AuthController {

    @PostMapping("/register")
    public String register(@RequestBody Object request) {
        return "User registered successfully";
    }

    @PostMapping("/login")
    public String login(@RequestBody Object request) {
        return "User logged in successfully";
    }
}

