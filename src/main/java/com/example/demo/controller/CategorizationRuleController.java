package com.example.demo.controller;

import com.example.demo.model.CategorizationRule;
import com.example.demo.repository.CategorizationRuleRepository;
import com.example.demo.service.CategorizationRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class CategorizationRuleController {

    private final CategorizationRuleService ruleService;
    private final CategorizationRuleRepository ruleRepository;

    public CategorizationRuleController(CategorizationRuleService ruleService,
                                        CategorizationRuleRepository ruleRepository) {
        this.ruleService = ruleService;
        this.ruleRepository = ruleRepository;
    }

    @PostMapping
    public CategorizationRule create(@RequestBody CategorizationRule rule) {
        return ruleService.createRule(rule);
    }

    @GetMapping("/category/{categoryId}")
    public List<CategorizationRule> getByCategory(@PathVariable Long categoryId) {
        return ruleRepository.findAll()
                .stream()
                .filter(r -> r.getCategory() != null &&
                             r.getCategory().getId().equals(categoryId))
                .toList();
    }

    @GetMapping("/{id}")
    public CategorizationRule getById(@PathVariable Long id) {
        return ruleRepository.findById(id).orElseThrow();
    }
}
