package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.CategorizationEngineService;
import com.example.demo.util.TicketCategorizationEngine;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategorizationEngineServiceImpl implements CategorizationEngineService {

    private final TicketRepository ticketRepository;
    private final CategorizationRuleRepository ruleRepository;
    private final UrgencyPolicyRepository policyRepository;
    private final CategorizationLogRepository logRepository;

    public CategorizationEngineServiceImpl(
            TicketRepository ticketRepository,
            CategorizationRuleRepository ruleRepository,
            UrgencyPolicyRepository policyRepository,
            CategorizationLogRepository logRepository
    ) {
        this.ticketRepository = ticketRepository;
        this.ruleRepository = ruleRepository;
        this.policyRepository = policyRepository;
        this.logRepository = logRepository;
    }

    @Override
    public Ticket categorize(Long ticketId) {

        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        List<CategorizationRule> rules =
                ruleRepository.findByKeywordContainingIgnoreCase("");

        List<UrgencyPolicy> policies =
                policyRepository.findAll();

        List<CategorizationLog> logs = new ArrayList<>();

        String urgency = TicketCategorizationEngine.categorize(
                ticket, rules, policies, logs
        );

        ticket.setUrgencyLevel(urgency);
        ticketRepository.save(ticket);
        logRepository.saveAll(logs);

        return ticket;
    }

    @Override
    public CategorizationLog getLog(Long logId) {
        return logRepository.findById(logId)
                .orElseThrow(() -> new RuntimeException("Log not found"));
    }

    @Override
    public List<CategorizationLog> getLogsForTicket(Long ticketId) {
        return logRepository.findByTicket_Id(ticketId);
    }
}
