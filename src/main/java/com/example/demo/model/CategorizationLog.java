package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "categorization_logs")
public class CategorizationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ✅ Ticket relation
    @ManyToOne(optional = false)
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    // ✅ Applied rule relation (MANDATORY for tests)
    @ManyToOne
    @JoinColumn(name = "rule_id")
    private CategorizationRule appliedRule;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    // =====================
    // JPA CALLBACK
    // =====================
    @PrePersist
    public void prePersist() {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }

    // =====================
    // GETTERS & SETTERS
    // =====================

    public Long getId() {
        return id;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    // ✅ REQUIRED BY TEST: testCategorizationLogAppliedRuleManyToOne
    public CategorizationRule getAppliedRule() {
        return appliedRule;
    }

    public void setAppliedRule(CategorizationRule appliedRule) {
        this.appliedRule = appliedRule;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
