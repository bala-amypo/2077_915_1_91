package com.example.demo.util;

import com.example.demo.model.*;
import java.util.Comparator;
import java.util.List;

public class TicketCategorizationEngine {

    public static UrgencyLevel categorize(
            Ticket ticket,
            List<CategorizationRule> rules,
            List<UrgencyPolicy> policies,
            List<CategorizationLog> logs
    ) {

        // ============================
        // 1. Apply highest priority rule
        // ============================
        CategorizationRule matchedRule = rules.stream()
                .filter(r -> ticket.getDescription() != null &&
                        ticket.getDescription().toLowerCase().contains(r.getKeyword().toLowerCase()))
                .max(Comparator.comparingInt(CategorizationRule::getPriority))
                .orElse(null);

        UrgencyLevel resultUrgency = null;

        if (matchedRule != null) {
            resultUrgency = matchedRule.getUrgency();

            // ✅ Log ONLY ticket + rule (NO business fields)
            CategorizationLog log = new CategorizationLog();
            log.setTicket(ticket);
            log.setAppliedRule(matchedRule);
            logs.add(log);
        }

        // ============================
        // 2. Policy override
        // ============================
        if (policies != null) {
            for (UrgencyPolicy policy : policies) {
                if (policy.getOverrideUrgency() != null) {
                    resultUrgency = policy.getOverrideUrgency();
                }
            }
        }

        // ============================
        // 3. Default LOW
        // ============================
        if (resultUrgency == null) {
            resultUrgency = UrgencyLevel.LOW;
        }

        return resultUrgency;
    }
}
