package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private String urgencyLevel;

    @ManyToOne
    private Category assignedCategory;

    private LocalDateTime createdAt;

    public Ticket() {
    }

    // ✅ REQUIRED BY TESTS
    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // ✅ REQUIRED
    public String getDescription() {
        return description;
    }

    // ✅ REQUIRED
    public void setDescription(String description) {
        this.description = description;
    }

    public Category getAssignedCategory() {
        return assignedCategory;
    }

    public void setAssignedCategory(Category assignedCategory) {
        this.assignedCategory = assignedCategory;
    }

    // ✅ REQUIRED
    public String getUrgencyLevel() {
        return urgencyLevel;
    }

    public void setUrgencyLevel(String urgencyLevel) {
        this.urgencyLevel = urgencyLevel;
    }

    // ✅ REQUIRED
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
