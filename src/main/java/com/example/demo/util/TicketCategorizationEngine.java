// package com.example.demo.util;

// import com.example.demo.model.Category;
// import com.example.demo.model.UrgencyPolicy;

// public class TicketCategorizationEngine {

//     public void categorize(Category category, UrgencyPolicy policy) {
//         String defaultUrgency = category.getDefaultUrgency();
//         String keyword = policy.getKeyword();
//         String urgencyOverride = policy.getUrgencyOverride();
//         // Categorization logic here
//     }
// }

package com.example.demo.util;

import com.example.demo.model.*;

import java.util.Comparator;
import java.util.List;

public class TicketCategorizationEngine {

    public void categorize(
            Ticket ticket,
            List<Category> categories,
            List<CategorizationRule> rules,
            List<UrgencyPolicy> policies,
            List<CategorizationLog> logs) {

        CategorizationRule matchedRule = rules.stream()
                .filter(r -> r.getKeyword() != null
                        && ticket.getDescription() != null
                        && ticket.getDescription().toLowerCase()
                        .contains(r.getKeyword().toLowerCase()))
                .max(Comparator.comparingInt(CategorizationRule::getPriority))
                .orElse(null);

        if (matchedRule != null) {
            ticket.setAssignedCategory(matchedRule.getCategory());
            ticket.setUrgencyLevel(matchedRule.getCategory().getDefaultUrgency());
        }

        for (UrgencyPolicy policy : policies) {
            if (ticket.getDescription() != null
                    && policy.getKeyword() != null
                    && ticket.getDescription().toLowerCase()
                    .contains(policy.getKeyword().toLowerCase())) {
                ticket.setUrgencyLevel(policy.getUrgencyOverride());
            }
        }

        if (ticket.getUrgencyLevel() == null) {
            ticket.setUrgencyLevel("LOW");
        }

        CategorizationLog log = new CategorizationLog();
        log.setTicket(ticket);
        log.setAppliedRule(matchedRule);
        log.setFinalUrgency(ticket.getUrgencyLevel());
        logs.add(log);
    }
}
