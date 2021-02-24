package com.example.gira2.service;

import com.example.gira2.model.entity.Classification;
import com.example.gira2.model.entity.ClassificationEnum;

public interface ClassificationService {
    void initClassifications();

    Classification findByClassification(ClassificationEnum classification);
}
