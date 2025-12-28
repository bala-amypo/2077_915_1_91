package com.example.demo.util;

import com.example.demo.model.*;

import java.util.List;

public class TicketCategorizationEngine {

    public Ticket categorize(
            Ticket ticket,
            List<CategorizationRule> rules,
            List<UrgencyPolicy> policies,
            List<CategorizationLog> logs
    ) {

        for (UrgencyPolicy policy : policies) {
            if (policy.getCategories().contains(ticket.getCategory())
                    && policy.getOverrideUrgency() != null) {

                ticket.setUrgencyLevel(policy.getOverrideUrgency());
                return ticket;
            }
        }

        for (CategorizationRule rule : rules) {
            if (ticket.getDescription() != null &&
                ticket.getDescription().toLowerCase()
                        .contains(rule.getKeyword().toLowerCase())) {

                ticket.setUrgencyLevel(rule.getUrgencyLevel());

                CategorizationLog log = new CategorizationLog();
                log.setTicket(ticket);
                log.setAppliedRule(rule);
                logs.add(log);

                return ticket;
            }
        }

        ticket.setUrgencyLevel(UrgencyLevel.LOW);
        return ticket;
    }
}
