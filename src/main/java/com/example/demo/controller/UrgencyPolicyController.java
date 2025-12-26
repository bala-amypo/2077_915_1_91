package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/policies")
@Tag(name = "Urgency Policy Controller")
public class UrgencyPolicyController {

    @PostMapping
    public String createPolicy(@RequestBody Object policy) {
        return "Policy created";
    }

    @GetMapping
    public String listPolicies() {
        return "List policies";
    }

    @GetMapping("/{id}")
    public String getPolicy(@PathVariable Long id) {
        return "Policy " + id;
    }
}
