package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "urgency_policies")
public class UrgencyPolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String keyword;
    private String urgencyOverride;
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() { return id; }

    public String getKeyword() { return keyword; }
    public void setKeyword(String keyword) { this.keyword = keyword; }

    // 🔥 REQUIRED BY TEST
    public void setPolicyName(String policyName) {
        this.keyword = policyName;
    }

    public String getUrgencyOverride() { return urgencyOverride; }
    public void setUrgencyOverride(String urgencyOverride) { this.urgencyOverride = urgencyOverride; }

    public LocalDateTime getCreatedAt() { return createdAt; }
}
