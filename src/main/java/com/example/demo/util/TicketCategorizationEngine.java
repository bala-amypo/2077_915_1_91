package com.example.demo.util;

import com.example.demo.model.*;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class TicketCategorizationEngine {

    public Ticket categorize(
            Ticket ticket,
            List<Category> categories,
            List<CategorizationRule> rules,
            List<UrgencyPolicy> policies,
            List<CategorizationLog> logs
    ) {

        for (CategorizationRule rule : rules) {
            if (ticket.getTitle() != null &&
                ticket.getTitle().toLowerCase()
                      .contains(rule.getKeyword().toLowerCase())) {

                Category category = categories.get(0);
                ticket.setAssignedCategory(category);
                ticket.setUrgency(category.getDefaultUrgency());
                return ticket;
            }
        }

        ticket.setUrgency("LOW");
        return ticket;
    }
}
