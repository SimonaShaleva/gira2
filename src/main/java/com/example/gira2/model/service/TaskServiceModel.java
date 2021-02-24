package com.example.gira2.model.service;

import com.example.gira2.model.entity.Classification;
import com.example.gira2.model.entity.ClassificationEnum;
import com.example.gira2.model.entity.ProgressEnum;
import com.example.gira2.model.entity.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TaskServiceModel {
    private String name;
    private String description;
    private ProgressEnum progressName;
    private LocalDate dueDate;
    private ClassificationEnum classification;
    private String username;

    public TaskServiceModel() {
    }

    public String getName() {
        return name;
    }

    public TaskServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public TaskServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public ProgressEnum getProgressName() {
        return progressName;
    }

    public TaskServiceModel setProgressName(ProgressEnum progressName) {
        this.progressName = progressName;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskServiceModel setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public ClassificationEnum getClassification() {
        return classification;
    }

    public TaskServiceModel setClassification(ClassificationEnum classification) {
        this.classification = classification;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public TaskServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }
}
