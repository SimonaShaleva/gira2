package com.example.gira2.model.entity;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
public class Task extends BaseEntity {
    private String name;
    private String description;
    private ProgressEnum progressName;
    private LocalDate dueDate;
    private Classification classification;
    private User user;

    public Task() {
    }

    public Task(ProgressEnum progressName) {
        this.progressName = progressName;
    }

    @Column(name = "name", unique = true, nullable = false)
    @Length(min = 3, max = 20, message = "Name length must be between 3 and 20 characters (inclusive 3 and 20).")
    public String getName() {
        return name;
    }

    public Task setName(String name) {
        this.name = name;
        return this;
    }

    @Column(name = "description", columnDefinition = "TEXT")
    @Length(min = 5, message = "Description min length must be minimum 5(inclusive) characters")
    public String getDescription() {
        return description;
    }

    public Task setDescription(String description) {
        this.description = description;
        return this;
    }

    @Column(name = "progress_name")
    @Enumerated(EnumType.STRING)
    public ProgressEnum getProgressName() {
        return progressName;
    }

    public Task setProgressName(ProgressEnum progress) {
        this.progressName = progress;
        return this;
    }

    @Column(name = "due_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "The date cannot be in the past!")
    public LocalDate getDueDate() {
        return dueDate;
    }

    public Task setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    @ManyToOne
    public Classification getClassification() {
        return classification;
    }

    public Task setClassification(Classification classification) {
        this.classification = classification;
        return this;
    }

    @ManyToOne
    public User getUser() {
        return user;
    }

    public Task setUser(User user) {
        this.user = user;
        return this;
    }
}
