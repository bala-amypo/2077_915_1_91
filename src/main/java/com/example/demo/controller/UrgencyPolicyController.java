package com.example.demo.controller;

import com.example.demo.model.UrgencyPolicy;
import com.example.demo.repository.UrgencyPolicyRepository;
import com.example.demo.service.UrgencyPolicyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policies")
public class UrgencyPolicyController {

    private final UrgencyPolicyService policyService;
    private final UrgencyPolicyRepository policyRepository;

    public UrgencyPolicyController(UrgencyPolicyService policyService,
                                   UrgencyPolicyRepository policyRepository) {
        this.policyService = policyService;
        this.policyRepository = policyRepository;
    }

    @PostMapping
    public UrgencyPolicy create(@RequestBody UrgencyPolicy policy) {
        return policyService.createPolicy(policy);
    }

    @GetMapping
    public List<UrgencyPolicy> getAll() {
        return policyRepository.findAll();
    }

    @GetMapping("/{id}")
    public UrgencyPolicy getById(@PathVariable Long id) {
        return policyService.getPolicy(id);
    }
}
