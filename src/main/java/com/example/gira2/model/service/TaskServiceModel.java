package com.example.gira2.model.service;

import com.example.gira2.model.entity.ClassificationEnum;
import com.example.gira2.model.entity.ProgressEnum;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class TaskServiceModel {
    private Long id;
    private String name;
    private String description;
    private ProgressEnum progressName;
    private LocalDate dueDate;
    private ClassificationEnum classification;
    private UserServiceModel userServiceModel;

    public TaskServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public TaskServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    @Length(min = 3, max = 20, message = "Name length must be between 3 and 20 characters (inclusive 3 and 20).")
    @NotBlank
    public String getName() {
        return name;
    }

    public TaskServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    @Length(min = 5, message = "Description min length must be minimum 5(inclusive) characters")
    @NotBlank
    public String getDescription() {
        return description;
    }

    public TaskServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    @NotNull
    public ProgressEnum getProgressName() {
        return progressName;
    }

    public TaskServiceModel setProgressName(ProgressEnum progressName) {
        this.progressName = progressName;
        return this;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "The date cannot be in the past!")
    @NotNull
    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskServiceModel setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    @NotNull
    public ClassificationEnum getClassification() {
        return classification;
    }

    public TaskServiceModel setClassification(ClassificationEnum classification) {
        this.classification = classification;
        return this;
    }

    public UserServiceModel getUserServiceModel() {
        return userServiceModel;
    }

    public TaskServiceModel setUserServiceModel(UserServiceModel userServiceModel) {
        this.userServiceModel = userServiceModel;
        return this;
    }
}
