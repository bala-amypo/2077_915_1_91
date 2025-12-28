package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private String urgencyLevel;

    @ManyToOne
    private Category category;

    public Long getId() { return id; }

    public String getDescription() { return description; }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrgencyLevel() { return urgencyLevel; }

    public void setUrgencyLevel(String urgencyLevel) {
        this.urgencyLevel = urgencyLevel;
    }

    public Category getCategory() { return category; }

    public void setCategory(Category category) {
        this.category = category;
    }
}
