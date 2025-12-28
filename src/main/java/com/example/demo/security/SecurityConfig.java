package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            // Disable CSRF
            .csrf(csrf -> csrf.disable())

            // Allow ALL requests without authentication
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll()
            )

            // Disable login page
            .formLogin(form -> form.disable())

            // Disable HTTP basic auth
            .httpBasic(basic -> basic.disable());

        return http.build();
    }
}
