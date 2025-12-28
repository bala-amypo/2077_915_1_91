package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class UrgencyPolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String urgency;

    @OneToMany(mappedBy = "urgencyPolicy")
    private List<Category> categories;

    public Long getId() {
        return id;
    }

    public String getUrgency() {
        return urgency;
    }

    public List<Category> getCategories() {
        return categories;
    }
}

