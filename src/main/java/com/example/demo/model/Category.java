package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoryName;
    private String defaultUrgency;

    @ManyToMany
    private Set<UrgencyPolicy> urgencyPolicies = new HashSet<>();

    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() { return id; }

    public String getCategoryName() { return categoryName; }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDefaultUrgency() { return defaultUrgency; }

    public void setDefaultUrgency(String defaultUrgency) {
        this.defaultUrgency = defaultUrgency;
    }

    public Set<UrgencyPolicy> getUrgencyPolicies() {
        return urgencyPolicies;
    }

    // 🔥 REQUIRED BY TEST
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
