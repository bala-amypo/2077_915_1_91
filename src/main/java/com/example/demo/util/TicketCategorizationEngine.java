package com.example.demo.util;

import com.example.demo.model.*;

import java.util.List;

public class TicketCategorizationEngine {

    public void categorize(
            Ticket ticket,
            List<Category> categories,
            List<CategorizationRule> rules,
            List<UrgencyPolicy> policies,
            List<CategorizationLog> logs
    ) {
        String desc = ticket.getDescription().toLowerCase();

        for (CategorizationRule rule : rules) {
            if (desc.contains(rule.getKeyword().toLowerCase())) {
                ticket.setAssignedCategory(rule.getCategory());
                ticket.setUrgencyLevel(rule.getCategory().getDefaultUrgency());

                CategorizationLog log = new CategorizationLog();
                log.setTicket(ticket);
                log.setAppliedRule(rule);
                logs.add(log);
                break;
            }
        }

        for (UrgencyPolicy p : policies) {
            if (desc.contains(p.getKeyword().toLowerCase())) {
                ticket.setUrgencyLevel(p.getUrgencyOverride());
            }
        }

        if (ticket.getUrgencyLevel() == null) {
            ticket.setUrgencyLevel("LOW");
        }
    }
}
