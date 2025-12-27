package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String assignedCategory;

    private String urgency;

    private LocalDateTime createdAt;

    // ===== GETTERS & SETTERS =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {   // TESTS REQUIRE THIS
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {  // TESTS REQUIRE THIS
        this.title = title;
    }

    public String getAssignedCategory() {  // TESTS REQUIRE THIS
        return assignedCategory;
    }

    public void setAssignedCategory(String assignedCategory) {
        this.assignedCategory = assignedCategory;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // ===== LIFECYCLE METHOD (TESTS REQUIRE THIS) =====
    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
}
