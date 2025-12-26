package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/rules")
@Tag(name = "Categorization Rule Controller")
public class CategorizationRuleController {

    @PostMapping("/{categoryId}")
    public String createRule(@PathVariable Long categoryId) {
        return "Rule created for category: " + categoryId;
    }

    @GetMapping("/category/{categoryId}")
    public String listRulesByCategory(@PathVariable Long categoryId) {
        return "Rules for category: " + categoryId;
    }

    @GetMapping("/{id}")
    public String getRuleById(@PathVariable Long id) {
        return "Rule id: " + id;
    }
}
