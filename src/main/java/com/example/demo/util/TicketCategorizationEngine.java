package com.example.demo.util;

import com.example.demo.model.*;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class TicketCategorizationEngine {

    public void categorize(
            Ticket ticket,
            List<Category> categories,
            List<CategorizationRule> rules,
            List<UrgencyPolicy> policies,
            List<CategorizationLog> logs
    ) {

        ticket.setUrgencyLevel("LOW");

        for (CategorizationRule rule : rules) {
            if (ticket.getDescription() != null &&
                rule.getKeyword() != null &&
                ticket.getDescription().toLowerCase().contains(rule.getKeyword().toLowerCase())) {

                ticket.setAssignedCategory(rule.getCategory());
                ticket.setUrgencyLevel(rule.getCategory().getDefaultUrgency());

                CategorizationLog log = new CategorizationLog();
                log.setTicket(ticket);
                log.setAppliedRule(rule);
                log.setAssignedCategory(rule.getCategory().getCategoryName());
                log.setAssignedUrgency(ticket.getUrgencyLevel());

                logs.add(log);
                break;
            }
        }

        for (UrgencyPolicy policy : policies) {
            if (ticket.getAssignedCategory() != null &&
                policy.getCategories().contains(ticket.getAssignedCategory())) {
                ticket.setUrgencyLevel(policy.getUrgencyOverride());
            }
        }
    }
}
