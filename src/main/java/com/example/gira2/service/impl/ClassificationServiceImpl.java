package com.example.gira2.service.impl;

import com.example.gira2.model.entity.Classification;
import com.example.gira2.model.entity.ClassificationEnum;
import com.example.gira2.repository.ClassificationRepository;
import com.example.gira2.service.ClassificationService;
import org.springframework.stereotype.Service;

@Service
public class ClassificationServiceImpl implements ClassificationService {
    private final ClassificationRepository classificationRepository;

    public ClassificationServiceImpl(ClassificationRepository classificationRepository) {
        this.classificationRepository = classificationRepository;
    }

    @Override
    public void initClassifications() {
        if (classificationRepository.count() != ClassificationEnum.values().length) {
            for (ClassificationEnum c : ClassificationEnum.values()) {
                classificationRepository.save(new Classification(c,
                        String.format("This is a %s problem!", c)));
            }
        }
    }

    @Override
    public Classification findByClassification(ClassificationEnum classification) {
        return classificationRepository.findByClassification(classification);
    }


}
