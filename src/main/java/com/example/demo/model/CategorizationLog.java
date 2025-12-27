package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class CategorizationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String assignedCategory;
    private String assignedUrgency;

    @ManyToOne
    private Ticket ticket;

    // ===== GETTERS & SETTERS =====

    public Long getId() {
        return id;
    }

    public String getAssignedCategory() {
        return assignedCategory;
    }

    public void setAssignedCategory(String assignedCategory) {
        this.assignedCategory = assignedCategory;
    }

    public String getAssignedUrgency() {
        return assignedUrgency;
    }

    public void setAssignedUrgency(String assignedUrgency) {
        this.assignedUrgency = assignedUrgency;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
