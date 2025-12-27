package com.example.demo.util;

import com.example.demo.model.*;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TicketCategorizationEngine {

    public Ticket categorize(
            Ticket ticket,
            List<CategorizationRule> rules,
            List<UrgencyPolicy> policies
    ) {

        // ===== CATEGORY ASSIGNMENT =====
        for (CategorizationRule rule : rules) {
            if (ticket.getTitle() != null &&
                ticket.getTitle().toLowerCase()
                        .contains(rule.getKeyword().toLowerCase())) {

                ticket.setAssignedCategory(
                        rule.getCategory().getCategoryName()
                );
                ticket.setUrgency(
                        rule.getCategory().getDefaultUrgency()
                );
                break;
            }
        }

        // ===== URGENCY OVERRIDE =====
        for (UrgencyPolicy policy : policies) {
            if (ticket.getTitle() != null &&
                ticket.getTitle().toLowerCase()
                        .contains(policy.getKeyword().toLowerCase())) {

                ticket.setUrgency(policy.getUrgencyOverride());
                break;
            }
        }

        return ticket;
    }
}
