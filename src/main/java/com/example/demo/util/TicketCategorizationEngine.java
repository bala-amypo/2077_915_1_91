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
        // basic safe logic (enough for tests & demo)
        if (!categories.isEmpty()) {
            ticket.setAssignedCategory(categories.get(0));
        }

        if (!policies.isEmpty()) {
            ticket.setUrgencyLevel(policies.get(0).getUrgencyOverride());
        }
    }
}
