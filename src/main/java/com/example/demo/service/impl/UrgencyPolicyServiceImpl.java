package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.UrgencyPolicy;
import com.example.demo.repository.UrgencyPolicyRepository;
import com.example.demo.service.UrgencyPolicyService;

public class UrgencyPolicyServiceImpl implements UrgencyPolicyService {

    private final UrgencyPolicyRepository repository;

    public UrgencyPolicyServiceImpl(UrgencyPolicyRepository repository) {
        this.repository = repository;
    }

    @Override
    public UrgencyPolicy createPolicy(UrgencyPolicy policy) {
        return repository.save(policy);
    }

    @Override
    public UrgencyPolicy getPolicy(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Policy not found"));
    }
}
