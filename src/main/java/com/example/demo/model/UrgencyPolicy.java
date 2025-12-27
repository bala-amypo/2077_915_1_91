package com.example.demo.model;

import jakarta.persistence.*;
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

    @ManyToMany(mappedBy = "urgencyPolicies")
    private Set<Category> categories = new HashSet<>();

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
