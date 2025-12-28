package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.CategorizationEngineService;
import org.springframework.stereotype.Service;

@Service
public class CategorizationEngineServiceImpl implements CategorizationEngineService {

    private final TicketRepository ticketRepo;
    private final CategorizationRuleRepository ruleRepo;
    private final CategorizationLogRepository logRepo;

    public CategorizationEngineServiceImpl(
            TicketRepository ticketRepo,
            CategorizationRuleRepository ruleRepo,
            CategorizationLogRepository logRepo) {
        this.ticketRepo = ticketRepo;
        this.ruleRepo = ruleRepo;
        this.logRepo = logRepo;
    }

    @Override
    public CategorizationLog categorizeTicket(Long ticketId) {
        Ticket ticket = ticketRepo.findById(ticketId).orElseThrow();

        for (CategorizationRule rule : ruleRepo.findAll()) {
            if (ticket.getDescription().contains(rule.getKeyword())) {
                ticket.setUrgencyLevel(rule.getUrgency());

                CategorizationLog log = new CategorizationLog();
                log.setTicket(ticket);
                log.setAppliedRule(rule);

                return logRepo.save(log);
            }
        }
        return null;
    }
}
