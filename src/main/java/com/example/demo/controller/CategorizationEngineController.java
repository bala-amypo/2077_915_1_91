package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategorizationEngineController {

    @GetMapping("/engine/run")
    public String runEngine() {
        return "Categorization engine executed successfully";
    }
}
