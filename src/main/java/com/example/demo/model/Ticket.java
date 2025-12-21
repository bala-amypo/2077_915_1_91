package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
public class Ticket {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;

  @Column(length = 1000)
  private String description;

  private String urgencyLevel;

  private LocalDateTime createdAt;

  @ManyToOne
  private Category assignedCategory;

  @PrePersist
  public void prePersist() {
    createdAt = LocalDateTime.now();
  }

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public String getTitle() { return title; }
  public void setTitle(String title) { this.title = title; }

  public String getDescription() { return description; }
  public void setDescription(String description) { this.description = description; }

  public String getUrgencyLevel() { return urgencyLevel; }
  public void setUrgencyLevel(String urgencyLevel) { this.urgencyLevel = urgencyLevel; }

  public Category getAssignedCategory() { return assignedCategory; }
  public void setAssignedCategory(Category assignedCategory) { this.assignedCategory = assignedCategory; }

  public LocalDateTime getCreatedAt() { return createdAt; }
}
