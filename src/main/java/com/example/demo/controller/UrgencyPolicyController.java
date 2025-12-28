package com.example.demo.controller;

import com.example.demo.service.UrgencyPolicyService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/policies")
public class UrgencyPolicyController {

    private final UrgencyPolicyService service;

    public UrgencyPolicyController(UrgencyPolicyService service) {
        this.service = service;
    }
}
