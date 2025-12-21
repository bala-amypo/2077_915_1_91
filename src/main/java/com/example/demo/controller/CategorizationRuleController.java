package com.example.demo.controller;

import com.example.demo.model.CategorizationRule;
import com.example.demo.repository.CategorizationRuleRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class CategorizationRuleController {

    private final CategorizationRuleRepository repo;

    public CategorizationRuleController(CategorizationRuleRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public CategorizationRule create(@RequestBody CategorizationRule r) {
        return repo.save(r);
    }

    @GetMapping
    public List<CategorizationRule> getAll() {
        return repo.findAll();
    }
}
