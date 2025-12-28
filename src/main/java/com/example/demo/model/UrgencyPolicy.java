package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class UrgencyPolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Used by repository
    private String keyword;

    // ✅ REQUIRED by tests
    private String policyName;

    // ✅ REQUIRED by tests
    private String urgencyOverride;

    // ✅ REQUIRED by tests
    private LocalDateTime createdAt;

    // ✅ REQUIRED by tests
    @ManyToMany
    private List<Category> categories = new ArrayList<>();

    public UrgencyPolicy() {
    }

    // ✅ REQUIRED
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

    // Repository needs this
    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    // ✅ REQUIRED
    public String getPolicyName() {
        return policyName;
    }

    // ✅ REQUIRED
    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public String getUrgencyOverride() {
        return urgencyOverride;
    }

    public void setUrgencyOverride(String urgencyOverride) {
        this.urgencyOverride = urgencyOverride;
    }

    // ✅ REQUIRED
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // ✅ REQUIRED
    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
