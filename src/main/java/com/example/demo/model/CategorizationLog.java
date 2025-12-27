package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

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

    private String finalUrgency;

    private LocalDateTime createdAt = LocalDateTime.now();

    public Long getId() {
        return id;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public CategorizationRule getAppliedRule() {
        return appliedRule;
    }

    public void setAppliedRule(CategorizationRule appliedRule) {
        this.appliedRule = appliedRule;
    }

    public String getFinalUrgency() {
        return finalUrgency;
    }

    public void setFinalUrgency(String finalUrgency) {
        this.finalUrgency = finalUrgency;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
