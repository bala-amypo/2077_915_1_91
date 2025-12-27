package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "categorization_rules")
public class CategorizationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String keyword;

    private String matchType;

    private Integer priority;

    @ManyToOne
    private Category category;

    @PrePersist
    protected void onCreate() {
        if (priority == null) {
            priority = 1;
        }
    }

    public String getKeyword() {
        return keyword;
    }

    public Category getCategory() {
        return category;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }
}
