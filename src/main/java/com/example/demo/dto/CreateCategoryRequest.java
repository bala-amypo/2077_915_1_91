package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;

public class CreateCategoryRequest {

    @NotBlank
    private String categoryName;

    @NotBlank
    private String defaultUrgency;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDefaultUrgency() {
        return defaultUrgency;
    }

    public void setDefaultUrgency(String defaultUrgency) {
        this.defaultUrgency = defaultUrgency;
    }
}
