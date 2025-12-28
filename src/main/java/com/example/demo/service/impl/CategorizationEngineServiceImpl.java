package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.CategorizationEngineService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorizationEngineServiceImpl implements CategorizationEngineService {

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

    // ✅ MUST MATCH INTERFACE
    @Override
    public Ticket categorizeTicket(Long ticketId) {

        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found"));

        List<CategorizationRule> rules =
                ruleRepository.findByKeywordContains(ticket.getDescription());

        UrgencyLevel urgency = UrgencyLevel.LOW;
        CategorizationRule appliedRule = null;

        if (!rules.isEmpty()) {
            appliedRule = rules.get(0);
            urgency = appliedRule.getUrgency(); // ✅ FIXED (see Rule fix below)
        }

        ticket.setUrgencyLevel(urgency);
        ticketRepository.save(ticket);

        CategorizationLog log = new CategorizationLog();
        log.setTicket(ticket);
        log.setAppliedRule(appliedRule); // ✅ REQUIRED BY TEST
        logRepository.save(log);

        return ticket;
    }

    @Override
    public CategorizationLog getLog(Long logId) {
        return logRepository.findById(logId)
                .orElseThrow(() -> new ResourceNotFoundException("Log not found"));
    }

    @Override
    public List<CategorizationLog> getLogsForTicket(Long ticketId) {
        return logRepository.findByTicketId(ticketId);
    }
}
