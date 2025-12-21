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

    
    ticket.setUrgencyLevel("LOW");
    rules.stream()
        .sorted(Comparator.comparingInt(CategorizationRule::getPriority).reversed())
        .filter(rule -> matches(rule, ticket))
        .findFirst()
        .ifPresent(rule -> {
          ticket.setAssignedCategory(rule.getCategory());
          ticket.setUrgencyLevel(rule.getCategory().getDefaultUrgency());

          CategorizationLog log = new CategorizationLog();
          log.setTicket(ticket);
          log.setAppliedRule(rule);
          logs.add(log);
        });

    for (UrgencyPolicy policy : policies) {
      if (ticket.getTitle() != null &&
          ticket.getTitle().toLowerCase().contains(policy.getKeyword().toLowerCase())
          ||
          ticket.getDescription() != null &&
          ticket.getDescription().toLowerCase().contains(policy.getKeyword().toLowerCase())) {

        ticket.setUrgencyLevel(policy.getUrgencyOverride());
      }
    }
  }

  private boolean matches(CategorizationRule rule, Ticket ticket) {
    String keyword = rule.getKeyword().toLowerCase();

    String title = ticket.getTitle() == null ? "" : ticket.getTitle().toLowerCase();
    String desc = ticket.getDescription() == null ? "" : ticket.getDescription().toLowerCase();

    return title.contains(keyword) || desc.contains(keyword);
  }
}
