package com.example.demo.controller;

import com.example.demo.model.CategorizationRule;
import com.example.demo.service.CategorizationRuleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class CategorizationRuleController {

    private final CategorizationRuleService ruleService;

    public CategorizationRuleController(CategorizationRuleService ruleService) {
        this.ruleService = ruleService;
    }

    @PostMapping("/{categoryId}")
    public CategorizationRule createRule(
            @PathVariable Long categoryId,
            @RequestBody CategorizationRule rule) {
        return ruleService.createRule(categoryId, rule);
    }

    @GetMapping("/category/{categoryId}")
    public List<CategorizationRule> getRulesByCategory(@PathVariable Long categoryId) {
        return ruleService.getRulesByCategory(categoryId);
    }

    @GetMapping("/{id}")
    public CategorizationRule getRule(@PathVariable Long id) {
        return ruleService.getRule(id);
    }
}
