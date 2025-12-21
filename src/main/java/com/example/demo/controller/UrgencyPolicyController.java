package com.example.demo.controller;

import com.example.demo.model.UrgencyPolicy;
import com.example.demo.service.UrgencyPolicyService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/policies")
public class UrgencyPolicyController {

  private final UrgencyPolicyService policyService;

  public UrgencyPolicyController(UrgencyPolicyService policyService) {
    this.policyService = policyService;
  }

  @PostMapping
  public UrgencyPolicy createPolicy(@RequestBody UrgencyPolicy policy) {
    return policyService.createPolicy(policy);
  }

  @GetMapping("/{id}")
  public UrgencyPolicy getPolicy(@PathVariable Long id) {
    return policyService.getPolicy(id);
  }
}
