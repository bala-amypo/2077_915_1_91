package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private String urgencyLevel;

    @ManyToOne
    @JoinColumn(name = "assigned_category_id")
    private Category assignedCategory;

    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrgencyLevel() {
        return urgencyLevel;
    }

    public void setUrgencyLevel(String urgencyLevel) {
        this.urgencyLevel = urgencyLevel;
    }

    public Category getAssignedCategory() {
        return assignedCategory;
    }

    public void setAssignedCategory(Category assignedCategory) {
        this.assignedCategory = assignedCategory;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
