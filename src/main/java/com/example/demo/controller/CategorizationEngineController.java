package com.example.demo.controller;

import com.example.demo.service.CategorizationEngineService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/engine")
public class CategorizationEngineController {

    private final CategorizationEngineService service;

    public CategorizationEngineController(CategorizationEngineService service) {
        this.service = service;
    }
}
