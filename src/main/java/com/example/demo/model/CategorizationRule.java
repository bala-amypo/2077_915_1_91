package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class CategorizationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String keyword;

    @Enumerated(EnumType.STRING)
    private UrgencyLevel urgencyLevel;

    public CategorizationRule() {}

    public Long getId() {
        return id;
    }

    public String getKeyword() {
        return keyword;
    }

    public UrgencyLevel getUrgencyLevel() {
        return urgencyLevel;
    }
}
