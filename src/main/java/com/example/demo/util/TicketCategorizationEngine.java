package com.example.demo.util;

import com.example.demo.model.*;

import java.util.List;

public class TicketCategorizationEngine {

  public void categorize(
      Ticket ticket,
      List<Category> categories,
      List<CategorizationRule> rules,
      List<UrgencyPolicy> policies,
      List<CategorizationLog> logs
  ) {

    for (CategorizationRule rule : rules) {
      if (ticket.getDescription() != null &&
          ticket.getDescription().toLowerCase()
              .contains(rule.getKeyword().toLowerCase())) {

        ticket.setCategory(rule.getCategory());

        CategorizationLog log = new CategorizationLog();
        log.setTicket(ticket);
        log.setAction("CATEGORY_ASSIGNED");
        log.setMessage("Category set using rule: " + rule.getKeyword());
        logs.add(log);
        break;
      }
    }

    for (UrgencyPolicy policy : policies) {
      if (ticket.getDescription() != null &&
          ticket.getDescription().toLowerCase()
              .contains(policy.getKeyword().toLowerCase())) {

        ticket.setUrgency(policy.getUrgencyLevel());

        CategorizationLog log = new CategorizationLog();
        log.setTicket(ticket);
        log.setAction("URGENCY_ASSIGNED");
        log.setMessage("Urgency set using policy: " + policy.getKeyword());
        logs.add(log);
        break;
      }
    }
  }
}
