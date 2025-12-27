package com.example.demo.controller;

import com.example.demo.dto.CreateRuleRequest;
import com.example.demo.model.CategorizationRule;
import com.example.demo.service.CategorizationRuleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rules")
public class CategorizationRuleController {

    private final CategorizationRuleService ruleService;

    public CategorizationRuleController(CategorizationRuleService ruleService) {
        this.ruleService = ruleService;
    }

    @PostMapping
    public CategorizationRule create(@RequestBody CreateRuleRequest request) {
        return ruleService.createRule(request);
    }
}
