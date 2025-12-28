package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class CategorizationRule {

    @Id
    @GeneratedValue
    private Long id;

    private String keyword;
    private String matchType;
    private int priority;

    @ManyToOne
    private Category category;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getKeyword() { return keyword; }
    public void setKeyword(String keyword) { this.keyword = keyword; }

    public String getMatchType() { return matchType; }
    public void setMatchType(String matchType) { this.matchType = matchType; }

    public int getPriority() { return priority; }
    public void setPriority(int priority) { this.priority = priority; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
}
