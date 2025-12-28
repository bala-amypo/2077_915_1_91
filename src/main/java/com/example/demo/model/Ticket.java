package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // REQUIRED by tests
    private String title;

    // REQUIRED by tests
    private String description;

    // REQUIRED by tests
    private String urgencyLevel;

    // REQUIRED by categorization
    @ManyToOne
    private Category assignedCategory;

    // REQUIRED by logs/tests
    private LocalDateTime createdAt;

    // REQUIRED by tests
    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    // ================= GETTERS & SETTERS =================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // ---- TITLE ----
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // ---- DESCRIPTION ----
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // ---- URGENCY LEVEL ----
    public String getUrgencyLevel() {
        return urgencyLevel;
    }

    public void setUrgencyLevel(String urgencyLevel) {
        this.urgencyLevel = urgencyLevel;
    }

    // ---- CATEGORY ----
    public Category getAssignedCategory() {
        return assignedCategory;
    }

    public void setAssignedCategory(Category assignedCategory) {
        this.assignedCategory = assignedCategory;
    }

    // ---- CREATED AT ----
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
