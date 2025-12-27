package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class UrgencyPolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String policyName;

    private String urgencyOverride;

    private LocalDateTime createdAt;

    @ManyToMany(mappedBy = "urgencyPolicies")
    private Set<Category> categories = new HashSet<>();

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public String getUrgencyOverride() {
        return urgencyOverride;
    }

    public void setUrgencyOverride(String urgencyOverride) {
        this.urgencyOverride = urgencyOverride;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Set<Category> getCategories() {
        return categories;
    }
}
