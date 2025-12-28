package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class UrgencyPolicy {

    @Id
    @GeneratedValue
    private Long id;

    private String keyword;
    private String urgencyOverride;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getKeyword() { return keyword; }
    public void setKeyword(String keyword) { this.keyword = keyword; }

    public String getUrgencyOverride() { return urgencyOverride; }
    public void setUrgencyOverride(String urgencyOverride) { this.urgencyOverride = urgencyOverride; }
}
