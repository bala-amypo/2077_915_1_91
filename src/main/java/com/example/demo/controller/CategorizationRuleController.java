package com.example.demo.controller;

import com.example.demo.model.CategorizationRule;
import com.example.demo.service.CategorizationRuleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rules")
public class CategorizationRuleController {

  private final CategorizationRuleService ruleService;

  public CategorizationRuleController(CategorizationRuleService ruleService) {
    this.ruleService = ruleService;
  }

  @PostMapping
  public CategorizationRule createRule(@RequestBody CategorizationRule rule) {
    return ruleService.createRule(rule);
  }

  @GetMapping("/{id}")
  public CategorizationRule getRule(@PathVariable Long id) {
    return ruleService.getRule(id);
  }
}
