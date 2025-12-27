package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.CategorizationEngineService;
import com.example.demo.util.TicketCategorizationEngine;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorizationEngineServiceImpl implements CategorizationEngineService {

    private final TicketRepository ticketRepository;
    private final CategoryRepository categoryRepository;
    private final CategorizationRuleRepository ruleRepository;
    private final UrgencyPolicyRepository policyRepository;
    private final CategorizationLogRepository logRepository;
    private final TicketCategorizationEngine engine;

    public CategorizationEngineServiceImpl(
            TicketRepository ticketRepository,
            CategoryRepository categoryRepository,
            CategorizationRuleRepository ruleRepository,
            UrgencyPolicyRepository policyRepository,
            CategorizationLogRepository logRepository,
            TicketCategorizationEngine engine
    ) {
        this.ticketRepository = ticketRepository;
        this.categoryRepository = categoryRepository;
        this.ruleRepository = ruleRepository;
        this.policyRepository = policyRepository;
        this.logRepository = logRepository;
        this.engine = engine;
    }

    @Override
    public Ticket categorize(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId).orElseThrow();

        List<Category> categories = categoryRepository.findAll();
        List<UrgencyPolicy> policies = policyRepository.findAll();

        Category category = categories.isEmpty() ? null : categories.get(0);
        UrgencyPolicy policy = policies.isEmpty() ? null : policies.get(0);

        if (category != null && policy != null) {
            engine.categorize(category, policy);
            ticket.setAssignedCategory(category);
            ticket.setUrgency(policy.getUrgencyOverride());
        }

        return ticketRepository.save(ticket);
    }

    @Override
    public CategorizationLog getLog(Long logId) {
        return logRepository.findById(logId).orElseThrow();
    }

    @Override
    public List<CategorizationLog> getLogsForTicket(Long ticketId) {
        return logRepository.findByTicket_Id(ticketId);
    }
}
