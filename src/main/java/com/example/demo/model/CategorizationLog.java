package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class CategorizationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Ticket ticket;

    @ManyToOne
    private CategorizationRule appliedRule;

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void setAppliedRule(CategorizationRule rule) {
        this.appliedRule = rule;
    }
}
