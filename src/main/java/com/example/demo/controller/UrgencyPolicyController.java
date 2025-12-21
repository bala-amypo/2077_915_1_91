package com.example.demo.controller;

import com.example.demo.model.UrgencyPolicy;
import com.example.demo.repository.UrgencyPolicyRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/urgency-policies")
public class UrgencyPolicyController {

    private final UrgencyPolicyRepository repo;

    public UrgencyPolicyController(UrgencyPolicyRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public UrgencyPolicy create(@RequestBody UrgencyPolicy p) {
        return repo.save(p);
    }

    @GetMapping
    public List<UrgencyPolicy> getAll() {
        return repo.findAll();
    }
}
