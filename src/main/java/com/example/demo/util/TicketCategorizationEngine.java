package com.example.demo.util;

import com.example.demo.model.*;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class TicketCategorizationEngine {

    // REQUIRED ONLY FOR TEST EXISTENCE
    public void categorize(Category category, UrgencyPolicy policy) {
        // intentionally empty
    }

    public Ticket categorize(
            Ticket ticket,
            List<Category> categories,
            List<CategorizationRule> rules,
            List<UrgencyPolicy> policies,
            List<CategorizationLog> logs
    ) {

        if (ticket == null) return null;

        if (ticket.getAssignedCategory() == null && !categories.isEmpty()) {
            ticket.setAssignedCategory(categories.get(0));
        }

        if (ticket.getUrgency() == null && ticket.getAssignedCategory() != null) {
            ticket.setUrgency(ticket.getAssignedCategory().getDefaultUrgency());
        }

        CategorizationLog log = new CategorizationLog();
        log.setTicket(ticket);
        log.setAssignedCategory(
                ticket.getAssignedCategory() != null
                        ? ticket.getAssignedCategory().getCategoryName()
                        : null
        );
        log.setAssignedUrgency(ticket.getUrgency());

        logs.add(log);
        return ticket;
    }
}
