package com.example.demo.model;

import jakarta.persistence.*;
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

    @PrePersist
    protected void onCreate() {
        if (defaultUrgency == null) {
            defaultUrgency = "LOW";
        }
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setDefaultUrgency(String defaultUrgency) {
        this.defaultUrgency = defaultUrgency;
    }

    public String getDefaultUrgency() {
        return defaultUrgency;
    }

    public Set<UrgencyPolicy> getUrgencyPolicies() {
        return urgencyPolicies;
    }
}
