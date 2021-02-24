package com.example.gira2.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "classifications")
public class Classification extends BaseEntity {
    private ClassificationEnum classification;
    private String description;

    public Classification() {
    }

    public Classification(ClassificationEnum classification) {
        this.classification = classification;
    }

    @Column(name = "classification_name", unique = true)
    @Enumerated(EnumType.STRING)
    public ClassificationEnum getClassification() {
        return classification;
    }

    public Classification setClassification(ClassificationEnum classification) {
        this.classification = classification;
        return this;
    }

    @Column(name = "description", columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public Classification setDescription(String description) {
        this.description = description;
        return this;
    }
}
