package com.example.demo.controller;

import com.example.demo.dto.CreateUrgencyPolicyRequest;
import com.example.demo.model.UrgencyPolicy;
import com.example.demo.service.UrgencyPolicyService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/policies")
public class UrgencyPolicyController {

    private final UrgencyPolicyService policyService;

    public UrgencyPolicyController(UrgencyPolicyService policyService) {
        this.policyService = policyService;
    }

    @PostMapping
    public UrencyPolicy create(@RequestBody CreateUrgencyPolicyRequest request) {
        return policyService.createPolicy(request);
    }

    @GetMapping("/{id}")
    public UrgencyPolicy get(@PathVariable Long id) {
        return policyService.getPolicyById(id);
    }
}
