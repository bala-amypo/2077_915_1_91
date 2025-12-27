package com.example.demo.util;

import com.example.demo.model.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TicketCategorizationEngine {

    public void categorize(
            Ticket ticket,
            List<CategorizationRule> rules,
            List<UrgencyPolicy> policies
    ) {
        String urgency = "LOW";
        Category matchedCategory = null;
        CategorizationRule matchedRule = null;

        for (CategorizationRule rule : rules) {
            if (ticket.getDescription() != null &&
                ticket.getDescription().toLowerCase()
                        .contains(rule.getKeyword().toLowerCase())) {

                matchedRule = rule;
                matchedCategory = rule.getCategory();
                break;
            }
        }

        if (matchedCategory != null) {
            ticket.setAssignedCategory(matchedCategory);
            urgency = matchedCategory.getDefaultUrgency();
        }

        for (UrgencyPolicy policy : policies) {
            if (matchedCategory != null &&
                policy.getCategories().contains(matchedCategory)) {
                urgency = policy.getUrgencyOverride();
            }
        }

        ticket.setUrgencyLevel(urgency);
    }
}
