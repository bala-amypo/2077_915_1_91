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
        String description = ticket.getDescription().toLowerCase();

        // Apply categorization rules
        for (CategorizationRule rule : rules) {
            if (description.contains(rule.getKeyword().toLowerCase())) {
                ticket.setAssignedCategory(rule.getCategory());
                ticket.setUrgencyLevel(rule.getCategory().getDefaultUrgency());

                CategorizationLog log = new CategorizationLog();
                log.setTicket(ticket);
                log.setAppliedRule(rule);
                logs.add(log);
                break;
            }
        }

        // Apply urgency override policies
        for (UrgencyPolicy policy : policies) {
            if (description.contains(policy.getKeyword().toLowerCase())) {
                ticket.setUrgencyLevel(policy.getUrgencyOverride());
            }
        }

        // Default urgency if nothing matched
        if (ticket.getUrgencyLevel() == null) {
            ticket.setUrgencyLevel("LOW");
        }
    }
}
