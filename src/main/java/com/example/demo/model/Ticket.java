package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ✅ REQUIRED by tests
    private String title;

    @ManyToOne
    private Category assignedCategory;

    private String urgency;

    // ✅ REQUIRED by tests
    private LocalDateTime createdAt;

    public Ticket() {
    }

    // ✅ REQUIRED by tests
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
    public String getTitle() {
        return title;
    }

    // ✅ REQUIRED
    public void setTitle(String title) {
        this.title = title;
    }

    public Category getAssignedCategory() {
        return assignedCategory;
    }

    public void setAssignedCategory(Category assignedCategory) {
        this.assignedCategory = assignedCategory;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    // ✅ REQUIRED
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
