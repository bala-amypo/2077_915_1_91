package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "categorization_logs")
public class CategorizationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Ticket ticket;

    @ManyToOne
    private CategorizationRule appliedRule;

    private String assignedCategory;
    private String assignedUrgency;

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void setAppliedRule(CategorizationRule appliedRule) {
        this.appliedRule = appliedRule;
    }

    public void setAssignedCategory(String assignedCategory) {
        this.assignedCategory = assignedCategory;
    }

    public void setAssignedUrgency(String assignedUrgency) {
        this.assignedUrgency = assignedUrgency;
    }
}
