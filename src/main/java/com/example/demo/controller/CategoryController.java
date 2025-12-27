package com.example.demo.controller;

import com.example.demo.dto.CreateCategoryRequest;
import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public Category create(@RequestBody CreateCategoryRequest request) {
        return categoryService.createCategory(request);
    }

    @GetMapping("/{id}")
    public Category get(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }
}
