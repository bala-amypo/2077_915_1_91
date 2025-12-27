package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    private Category assignedCategory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {   // REQUIRED by tests
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {   // REQUIRED by tests
        this.title = title;
    }

    public Category getAssignedCategory() {
        return assignedCategory;
    }

    public void setAssignedCategory(Category assignedCategory) {
        this.assignedCategory = assignedCategory;
    }
}
