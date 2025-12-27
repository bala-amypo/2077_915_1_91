package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "urgency_policies")
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
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public void setUrgencyOverride(String urgencyOverride) {
        this.urgencyOverride = urgencyOverride;
    }

    public String getUrgencyOverride() {
        return urgencyOverride;
    }

    public Set<Category> getCategories() {
        return categories;
    }
}
