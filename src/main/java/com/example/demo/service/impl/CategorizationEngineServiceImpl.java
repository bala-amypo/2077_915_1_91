package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.stereotype.Service;

@Service
public class CategorizationEngineServiceImpl {

    private final TicketRepository ticketRepository;
    private final CategorizationRuleRepository ruleRepository;
    private final CategorizationLogRepository logRepository;

    public CategorizationEngineServiceImpl(
            TicketRepository ticketRepository,
            CategorizationRuleRepository ruleRepository,
            CategorizationLogRepository logRepository) {
        this.ticketRepository = ticketRepository;
        this.ruleRepository = ruleRepository;
        this.logRepository = logRepository;
    }

    public CategorizationLog categorize(Ticket ticket) {
        for (CategorizationRule rule : ruleRepository.findAll()) {
            if (ticket.getTitle().contains(rule.getKeyword())) {
                ticket.setAssignedCategory(rule.getCategory());

                CategorizationLog log = new CategorizationLog();
                log.setTicket(ticket);
                log.setAppliedRule(rule);
                return logRepository.save(log);
            }
        }
        return null;
    }
}
