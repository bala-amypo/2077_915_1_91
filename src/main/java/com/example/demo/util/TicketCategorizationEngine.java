package com.example.demo.util;

import com.example.demo.model.CategorizationRule;
import com.example.demo.model.Ticket;
import com.example.demo.model.UrgencyPolicy;

import java.util.List;

public class TicketCategorizationEngine {

    public void categorize(Ticket ticket,
                           List<CategorizationRule> rules,
                           List<UrgencyPolicy> policies) {

        // DEFAULT urgency if nothing matches
        ticket.setUrgencyLevel("LOW");

        // Apply categorization rules
        for (CategorizationRule rule : rules) {
            if (ticket.getDescription() != null &&
                rule.getKeyword() != null &&
                ticket.getDescription().toLowerCase()
                        .contains(rule.getKeyword().toLowerCase())) {

                ticket.setCategory(rule.getCategory());
                ticket.setUrgencyLevel("HIGH");
                break;
            }
        }

        // Apply urgency policy override
        for (UrgencyPolicy policy : policies) {
            if (ticket.getCategory() != null &&
                policy.getCategories().contains(ticket.getCategory())) {

                ticket.setUrgencyLevel(policy.getUrgencyLevel());
            }
        }
    }
}
