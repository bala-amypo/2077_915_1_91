package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/categories")
@Tag(name = "Category Controller")
public class CategoryController {

    @PostMapping
    public String createCategory(@RequestBody Object category) {
        return "Category created";
    }

    @GetMapping
    public String listCategories() {
        return "List of categories";
    }

    @GetMapping("/{id}")
    public String getCategory(@PathVariable Long id) {
        return "Category " + id;
    }
}
