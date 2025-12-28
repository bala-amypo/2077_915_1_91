package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String defaultUrgency;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDefaultUrgency() { return defaultUrgency; }
    public void setDefaultUrgency(String defaultUrgency) { this.defaultUrgency = defaultUrgency; }
}
