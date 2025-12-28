package com.example.demo.util;

import com.example.demo.model.*;

import java.util.Comparator;
import java.util.List;

public class TicketCategorizationEngine {

    public static String categorize(
            Ticket ticket,
            List<CategorizationRule> rules,
            List<UrgencyPolicy> policies,
            List<CategorizationLog> logs
    ) {

        String urgency = null;
        CategorizationRule appliedRule = null;

        if (ticket != null && ticket.getDescription() != null) {
            appliedRule = rules.stream()
                    .filter(r -> ticket.getDescription()
                            .toLowerCase()
                            .contains(r.getKeyword().toLowerCase()))
                    .max(Comparator.comparingInt(CategorizationRule::getPriority))
                    .orElse(null);
        }

        if (appliedRule != null) {
            urgency = appliedRule.getUrgency();

            CategorizationLog log = new CategorizationLog();
            log.setTicket(ticket);
            log.setAppliedRule(appliedRule);
            logs.add(log);
        }

        // ✅ policy override
        if (policies != null) {
            for (UrgencyPolicy p : policies) {
                if (p.getUrgencyOverride() != null) {
                    urgency = p.getUrgencyOverride();
                }
            }
        }

        // ✅ default
        if (urgency == null) {
            urgency = "LOW";
        }

        return urgency;
    }
}
