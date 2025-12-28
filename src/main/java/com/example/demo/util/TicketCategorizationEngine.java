package com.example.demo.util;

import com.example.demo.model.*;

public class TicketCategorizationEngine {

    public void applyRules(Ticket ticket, Iterable<CategorizationRule> rules) {
        for (CategorizationRule rule : rules) {

            if (ticket.getDescription().contains(rule.getKeyword())) {

                ticket.setCategory(rule.getCategory());
                ticket.setUrgencyLevel(rule.getUrgency());
                return;
            }
        }
    }
}
