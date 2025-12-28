package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class CategorizationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String keyword;

    private String urgency;

    @ManyToOne
    private Category category;

    public Long getId() {
        return id;
    }

    public String getKeyword() {
        return keyword;
    }

    public String getUrgency() {
        return urgency;
    }

    public Category getCategory() {
        return category;
    }
}
