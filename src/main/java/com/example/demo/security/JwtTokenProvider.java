package com.example.demo.security;

public class JwtTokenProvider {

    public String generateToken(String username) {
        return "dummy-token";
    }

    public String getUsernameFromToken(String token) {
        return null;
    }

    public boolean validateToken(String token) {
        return true;
    }
}
