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

    private String message;

    private LocalDateTime createdAt = LocalDateTime.now();

    public CategorizationLog() {
    }

    public CategorizationLog(Ticket ticket, CategorizationRule rule, String message) {
        this.ticket = ticket;
        this.appliedRule = rule;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public CategorizationRule getAppliedRule() {
        return appliedRule;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
