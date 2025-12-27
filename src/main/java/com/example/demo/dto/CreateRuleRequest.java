package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;

public class CreateRuleRequest {

    @NotBlank
    private String keyword;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
