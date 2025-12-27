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
    private final CategorizationRuleRepository ruleRepository;
    private final UrgencyPolicyRepository policyRepository;
    private final CategorizationLogRepository logRepository;
    private final TicketCategorizationEngine engine;

    public CategorizationEngineServiceImpl(
            TicketRepository ticketRepository,
            CategorizationRuleRepository ruleRepository,
            UrgencyPolicyRepository policyRepository,
            CategorizationLogRepository logRepository,
            TicketCategorizationEngine engine
    ) {
        this.ticketRepository = ticketRepository;
        this.ruleRepository = ruleRepository;
        this.policyRepository = policyRepository;
        this.logRepository = logRepository;
        this.engine = engine;
    }

    @Override
    public Ticket categorizeTicket(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        List<CategorizationRule> rules = ruleRepository.findAll();
        List<UrgencyPolicy> policies = policyRepository.findAll();

        engine.categorize(ticket, rules, policies);

        ticketRepository.save(ticket);
        return ticket;
    }

    @Override
    public List<CategorizationLog> getLogsForTicket(Long ticketId) {
        return logRepository.findByTicket_Id(ticketId);
    }

    @Override
    public CategorizationLog getLog(Long id) {
        return logRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Log not found"));
    }
}
