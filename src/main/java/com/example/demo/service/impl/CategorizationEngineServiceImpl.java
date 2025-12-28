package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.CategorizationEngineService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorizationEngineServiceImpl implements CategorizationEngineService {

    private final TicketRepository ticketRepository;
    private final CategoryRepository categoryRepository;
    private final CategorizationRuleRepository ruleRepository;
    private final UrgencyPolicyRepository policyRepository;
    private final CategorizationLogRepository logRepository;

    public CategorizationEngineServiceImpl(
            TicketRepository ticketRepository,
            CategoryRepository categoryRepository,
            CategorizationRuleRepository ruleRepository,
            UrgencyPolicyRepository policyRepository,
            CategorizationLogRepository logRepository
    ) {
        this.ticketRepository = ticketRepository;
        this.categoryRepository = categoryRepository;
        this.ruleRepository = ruleRepository;
        this.policyRepository = policyRepository;
        this.logRepository = logRepository;
    }

    @Override
    public Ticket categorize(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found"));

        String urgency = "LOW"; // DEFAULT

        // Apply rule
        List<CategorizationRule> rules =
                ruleRepository.findByKeywordContainingIgnoreCase(ticket.getDescription());

        CategorizationRule appliedRule = null;
        if (!rules.isEmpty()) {
            appliedRule = rules.get(0);
            urgency = appliedRule.getUrgencyLevel();
        }

        // Apply policy override
        List<UrgencyPolicy> policies =
                policyRepository.findByKeywordContainingIgnoreCase(ticket.getDescription());

        if (!policies.isEmpty()) {
            urgency = policies.get(0).getUrgencyOverride();
        }

        ticket.setUrgencyLevel(urgency);
        ticketRepository.save(ticket);

        CategorizationLog log = new CategorizationLog();
        log.setTicket(ticket);
        log.setAssignedUrgency(urgency);
        log.setAppliedRule(appliedRule);

        logRepository.save(log);
        return ticket;
    }

    @Override
    public CategorizationLog getLog(Long logId) {
        return logRepository.findById(logId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Log not found"));
    }

    @Override
    public List<CategorizationLog> getLogsForTicket(Long ticketId) {
        return logRepository.findByTicket_Id(ticketId);
    }
}
