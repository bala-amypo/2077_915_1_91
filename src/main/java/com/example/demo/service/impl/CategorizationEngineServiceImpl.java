package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.CategorizationEngineService;
import com.example.demo.util.TicketCategorizationEngine;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorizationEngineServiceImpl
        implements CategorizationEngineService {

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
    public Ticket categorize(Long ticketId) {

        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow();

        List<CategorizationRule> rules = ruleRepository.findAll();
        List<UrgencyPolicy> policies = policyRepository.findAll();

        Ticket updated = engine.categorize(ticket, rules, policies);

        ticketRepository.save(updated);

        CategorizationLog log = new CategorizationLog();
        log.setTicket(updated);
        log.setAssignedCategory(updated.getAssignedCategory());
        log.setAssignedUrgency(updated.getUrgency());

        logRepository.save(log);

        return updated;
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
