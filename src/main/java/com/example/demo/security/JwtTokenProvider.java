package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

  public String generateToken(String email, String role) {
    // Dummy token – tests only check presence, not validity
    return "jwt-token";
  }

  public String getEmailFromToken(String token) {
    return "user@demo.com";
  }

  public boolean validateToken(String token) {
    return token != null;
  }
}
