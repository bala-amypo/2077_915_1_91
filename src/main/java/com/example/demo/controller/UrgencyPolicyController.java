package com.example.demo.controller;

import com.example.demo.model.UrgencyPolicy;
import com.example.demo.service.UrgencyPolicyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policies")
public class UrgencyPolicyController {

    private final UrgencyPolicyService policyService;

    public UrgencyPolicyController(UrgencyPolicyService policyService) {
        this.policyService = policyService;
    }

    @PostMapping
    public UrgencyPolicy createPolicy(@RequestBody UrgencyPolicy policy) {
        return policyService.createPolicy(policy);
    }

    @GetMapping
    public List<UrgencyPolicy> getAllPolicies() {
        return policyService.getAllPolicies();
    }

    @GetMapping("/{id}")
    public UrgencyPolicy getPolicy(@PathVariable Long id) {
        return policyService.getPolicy(id);
    }
}
