package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "logs")
public class CategorizationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Ticket ticket;

    private String assignedCategory;

    private String assignedUrgency;

    // ===== REQUIRED METHODS =====

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void setAssignedCategory(String assignedCategory) {
        this.assignedCategory = assignedCategory;
    }

    public void setAssignedUrgency(String assignedUrgency) {
        this.assignedUrgency = assignedUrgency;
    }
}
