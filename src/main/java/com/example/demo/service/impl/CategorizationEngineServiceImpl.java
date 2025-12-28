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
    private final UrgencyPolicyRepository urgencyPolicyRepository;
    private final CategorizationLogRepository logRepository;
    private final TicketCategorizationEngine engine;

    public CategorizationEngineServiceImpl(
            TicketRepository ticketRepository,
            CategoryRepository categoryRepository,
            CategorizationRuleRepository ruleRepository,
            UrgencyPolicyRepository urgencyPolicyRepository,
            CategorizationLogRepository logRepository,
            TicketCategorizationEngine engine
    ) {
        this.ticketRepository = ticketRepository;
        this.categoryRepository = categoryRepository;
        this.ruleRepository = ruleRepository;
        this.urgencyPolicyRepository = urgencyPolicyRepository;
        this.logRepository = logRepository;
        this.engine = engine;
    }

    // ✅ REQUIRED BY TESTS
    @Override
    public Ticket categorizeTicket(Long ticketId) {

        Ticket ticket = ticketRepository.findById(ticketId).orElse(null);
        if (ticket == null) {
            return null;
        }

        List<Category> categories = categoryRepository.findAll();
        List<CategorizationRule> rules = ruleRepository.findAll();
        List<UrgencyPolicy> policies = urgencyPolicyRepository.findAll();
        List<CategorizationLog> logs = logRepository.findAll();

        Ticket result = engine.categorize(ticket, categories, rules, policies, logs);

        ticketRepository.save(result);
        logRepository.saveAll(logs);

        return result;
    }

    @Override
    public CategorizationLog getLog(Long logId) {
        return logRepository.findById(logId).orElse(null);
    }

    // ✅ THIS METHOD WAS MISSING — NOW FIXED
    @Override
    public List<CategorizationLog> getLogsForTicket(Long ticketId) {
        return logRepository.findByTicket_Id(ticketId);
    }
}
