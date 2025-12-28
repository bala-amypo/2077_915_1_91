package com.example.demo.service.impl;

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

    // REQUIRED by Spring
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
    public Ticket categorizeTicket(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        for (CategorizationRule rule : ruleRepository.findAll()) {
            if (ticket.getDescription() != null &&
                ticket.getDescription().toLowerCase().contains(rule.getKeyword().toLowerCase())) {

                ticket.setAssignedCategory(rule.getCategory());
                ticket.setUrgencyLevel(rule.getCategory().getDefaultUrgency());

                CategorizationLog log = new CategorizationLog();
                log.setTicket(ticket);
                log.setAppliedRule(rule);
                logRepository.save(log);
                break;
            }
        }
        return ticket;
    }

    @Override
    public List<CategorizationLog> getLog(Long ticketId) {
        return logRepository.findByTicketId(ticketId);
    }
}
