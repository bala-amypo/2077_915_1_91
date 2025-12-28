package com.example.demo.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class UrgencyPolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String policyName;

    @Enumerated(EnumType.STRING)
    private UrgencyLevel overrideUrgency;

    @ManyToMany
    private Set<Category> categories = new HashSet<>();

    public UrgencyPolicy() {}

    public UrgencyLevel getOverrideUrgency() {
        return overrideUrgency;
    }

    public Set<Category> getCategories() {
        return categories;
    }
}
