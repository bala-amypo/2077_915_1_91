package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private UrgencyPolicy urgencyPolicy;

    public Long getId() { return id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public UrgencyPolicy getUrgencyPolicy() {
        return urgencyPolicy;
    }

    public void setUrgencyPolicy(UrgencyPolicy urgencyPolicy) {
        this.urgencyPolicy = urgencyPolicy;
    }
}
