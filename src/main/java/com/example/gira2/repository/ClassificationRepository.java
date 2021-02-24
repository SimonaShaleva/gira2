package com.example.gira2.repository;

import com.example.gira2.model.entity.Classification;
import com.example.gira2.model.entity.ClassificationEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassificationRepository extends JpaRepository<Classification, Long> {
    Classification findByClassification(ClassificationEnum classification);
}
