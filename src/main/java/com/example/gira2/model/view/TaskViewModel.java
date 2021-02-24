package com.example.gira2.model.view;

import com.example.gira2.model.entity.ClassificationEnum;
import com.example.gira2.model.entity.ProgressEnum;

import java.time.LocalDate;

public class TaskViewModel {
    private Long id;
    private String name;
    private String assignedTo;
    private ClassificationEnum classification;
    private LocalDate dueDate;
    private ProgressEnum progressEnum;

    public TaskViewModel() {
    }

    public Long getId() {
        return id;
    }

    public TaskViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TaskViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public TaskViewModel setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
        return this;
    }

    public ClassificationEnum getClassification() {
        return classification;
    }

    public TaskViewModel setClassification(ClassificationEnum classification) {
        this.classification = classification;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskViewModel setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public ProgressEnum getProgressEnum() {
        return progressEnum;
    }

    public TaskViewModel setProgressEnum(ProgressEnum progressEnum) {
        this.progressEnum = progressEnum;
        return this;
    }
}
