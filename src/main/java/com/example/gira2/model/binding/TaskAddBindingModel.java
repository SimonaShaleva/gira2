package com.example.gira2.model.binding;

import com.example.gira2.model.entity.ClassificationEnum;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class TaskAddBindingModel {
    private String name;
    private String description;
    private LocalDate dueDate;
    private ClassificationEnum classification;

    public TaskAddBindingModel() {
    }

    @Length(min = 3, max = 20, message = "Name length must be between 3 and 20 characters (inclusive 3 and 20).")
    @NotBlank(message = "Please enter valid value!")
    public String getName() {
        return name;
    }

    public TaskAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    @Length(min = 5, message = "Description min length must be minimum 5(inclusive) characters")
    @NotBlank(message = "Please enter valid value!")
    public String getDescription() {
        return description;
    }

    public TaskAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "The date cannot be in the past!")
    @NotNull(message = "Please enter valid value!")
    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskAddBindingModel setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    @NotNull(message = "Choose classification!")
    public ClassificationEnum getClassification() {
        return classification;
    }

    public TaskAddBindingModel setClassification(ClassificationEnum classification) {
        this.classification = classification;
        return this;
    }
}
