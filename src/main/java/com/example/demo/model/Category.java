package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoryName;

    private String defaultUrgency;

    private LocalDateTime createdAt;

    @ManyToMany
    @JoinTable(
        name = "categories_urgency_policies",
        joinColumns = @JoinColumn(name = "categories_id"),
        inverseJoinColumns = @JoinColumn(name = "urgency_policies_id")
    )
    private List<UrgencyPolicy> urgencyPolicies = new ArrayList<>();

    public Category() {
    }

    public Long getId() {
        return id;
    }

    // REQUIRED BY TESTS
    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDefaultUrgency() {
        return defaultUrgency;
    }

    public void setDefaultUrgency(String defaultUrgency) {
        this.defaultUrgency = defaultUrgency;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // REQUIRED BY TESTS
    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    // REQUIRED BY TESTS
    public List<UrgencyPolicy> getUrgencyPolicies() {
        return urgencyPolicies;
    }
}
