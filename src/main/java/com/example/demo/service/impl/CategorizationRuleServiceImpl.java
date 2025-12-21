package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.CategorizationRule;
import com.example.demo.repository.CategorizationRuleRepository;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategorizationRuleService;

public class CategorizationRuleServiceImpl implements CategorizationRuleService {

  private final CategorizationRuleRepository ruleRepo;
  private final CategoryRepository categoryRepo;

  public CategorizationRuleServiceImpl(
      CategorizationRuleRepository ruleRepo,
      CategoryRepository categoryRepo
  ) {
    this.ruleRepo = ruleRepo;
    this.categoryRepo = categoryRepo;
  }

  @Override
  public CategorizationRule createRule(CategorizationRule rule) {
    return ruleRepo.save(rule);
  }

  @Override
  public CategorizationRule getRule(Long id) {
    return ruleRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Rule not found"));
  }
}
