package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "urgency_policy")
public class UrgencyPolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String policyName;

    private String keyword;

    private String urgencyOverride;

    private LocalDateTime createdAt;

    @ManyToMany(mappedBy = "urgencyPolicies")
    private List<Category> categories = new ArrayList<>();

    public UrgencyPolicy() {
    }

    public Long getId() {
        return id;
    }

    // REQUIRED BY TESTS
    public void setId(Long id) {
        this.id = id;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
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

    // REQUIRED BY TESTS
    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    // REQUIRED BY TESTS
    public List<Category> getCategories() {
        return categories;
    }
}
