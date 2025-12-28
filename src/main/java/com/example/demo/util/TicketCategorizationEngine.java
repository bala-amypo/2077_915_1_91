package com.example.demo.util;

import com.example.demo.model.*;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;

@Component
public class TicketCategorizationEngine {

    public void categorize(Ticket ticket,
                           List<Category> categories,
                           List<CategorizationRule> rules,
                           List<UrgencyPolicy> policies,
                           List<CategorizationLog> logs) {

        CategorizationRule matchedRule = rules.stream()
                .sorted(Comparator.comparing(CategorizationRule::getPriority).reversed())
                .filter(r -> matches(ticket, r))
                .findFirst()
                .orElse(null);

        if (matchedRule != null) {
            ticket.setAssignedCategory(matchedRule.getCategory());
            ticket.setUrgencyLevel(matchedRule.getCategory().getDefaultUrgency());
            logs.add(new CategorizationLog(ticket, matchedRule, "Rule matched"));
        }

        for (UrgencyPolicy policy : policies) {
            if (ticket.getDescription() != null &&
                ticket.getDescription().toLowerCase().contains(policy.getKeyword().toLowerCase())) {
                ticket.setUrgencyLevel(policy.getUrgencyOverride());
            }
        }

        if (ticket.getUrgencyLevel() == null) {
            ticket.setUrgencyLevel("LOW");
        }
    }

    private boolean matches(Ticket ticket, CategorizationRule rule) {
        String text = (ticket.getTitle() + " " + ticket.getDescription())
                .toLowerCase(Locale.ROOT);
        return text.contains(rule.getKeyword().toLowerCase());
    }
}
